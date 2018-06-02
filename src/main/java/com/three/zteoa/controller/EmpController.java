package com.three.zteoa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.EmpService;
import com.three.zteoa.service.PositionService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;
	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private PositionService positionService;
	@Autowired
	private AuthorityService authorityService;

	@PostMapping("/add")
	public UpdateVo add(@RequestBody Emp updateEmp, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		// 查询出position，否则进行isAuthorityUpdateEmp会抛出NPE异常
		updateEmp.setPosition(positionService.queryById(updateEmp.getPid()));
		UpdateVo updateVo = securityComponent.isAuthorityUpdateEmp(emp, updateEmp, TypeEnum.ADD);
		if (updateVo.isBl()) {
			return empService.register(updateEmp);
		}
		return updateVo;
	}

	@PostMapping("/update")
	public UpdateVo update(@RequestBody Emp updateEmp, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		// 必须执行查收若直接使用updateEmp将会导致position为null
		Emp udpate = empService.queryById(updateEmp.getId());
		udpate.setPosition(positionService.queryById(updateEmp.getPid()));
		UpdateVo updateVo = securityComponent.isAuthorityUpdateEmp(emp, udpate, TypeEnum.UDPATE);
		if (updateVo.isBl()) {
			return empService.update(updateEmp);
		}
		return updateVo;
	}

	@GetMapping("/delete")
	public UpdateVo delete(Integer id, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		Emp updateEmp = empService.queryById(id);
		UpdateVo updateVo = securityComponent.isAuthorityUpdateEmp(emp, updateEmp, TypeEnum.UDPATE);
		if (updateVo.isBl()) {
			return empService.delete(id);
		}
		return updateVo;
	}

	@RequestMapping("/queryList")
	public List<Emp> queryList(@RequestBody(required = false) Emp emp) {
		if (emp == null) {
			return empService.queryAll(1, 5, emp);
		}
		return empService.queryAll(emp.getCurrPage(), emp.getPageSize(), emp);
	}

	@RequestMapping("/queryTotal")
	public long queryTotal(@RequestBody(required = false) Emp emp) {
		return empService.getCount(emp);
	}

	@RequestMapping("/isRegister")
	public boolean isRegister(String username) {
		return !empService.isRegister(username);
	}

	@RequestMapping("/isLogin")
	public boolean isLogin(HttpSession session) {
		return session.getAttribute("empSession") != null;
	}

	@RequestMapping("/login")
	public boolean login(@RequestBody Emp emp, HttpSession session) {
		if (empService.login(emp)) {
			emp = empService.queryByUsername(emp.getUsername());
			session.setAttribute("empSession", emp);
			return true;
		}
		return false;
	}

	@RequestMapping("/getEmp")
	public Emp getEmp(HttpSession session) {
		return (Emp) session.getAttribute("empSession");
	}

	@RequestMapping("/exit")
	public boolean exit(HttpSession session) {
		session.removeAttribute("empSession");
		return true;
	}
	
	@RequestMapping("/getAuthoritys")
	public List<Authority> getAuthoritys(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return authorityService.queryByEmpAndModule(emp, ModuleEnum.EMP_MANAGER);
	}

}
