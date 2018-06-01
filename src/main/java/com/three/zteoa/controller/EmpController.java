package com.three.zteoa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Position;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.service.EmpService;
import com.three.zteoa.service.PositionService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;
	@Autowired
	private PositionService positionService;

	@PostMapping("/add")
	public UpdateVo add(@RequestBody Emp updateEmp, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		Position position = positionService.queryById(updateEmp.getPid());
		UpdateVo updateVo = SecurityComponent.isUpdateAuthority(emp, position.getName());
		if (updateVo.isBl()) {
			return empService.register(updateEmp);
		}
		return updateVo;
	}

	@PostMapping("/update")
	public UpdateVo update(@RequestBody Emp updateEmp, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		Emp updateEmp1 = empService.queryByUsername(updateEmp.getUsername());
		System.out.println(updateEmp);
		UpdateVo updateVo = SecurityComponent.isUpdateAuthority(emp, updateEmp1.getPosition().getName());
		if (updateVo.isBl()) {
			return empService.update(updateEmp);
		}
		return updateVo;
	}

	@GetMapping("/delete")
	public boolean delete(Integer id) {
		return empService.delete(id);
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

	/**
	 * 验证更新权限
	 * 
	 * @param updateEmp
	 * @param session
	 * @return
	 */
	@RequestMapping("/isAuthority")
	public UpdateVo isAuthority(@RequestBody(required = false) Emp updateEmp, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		if (updateEmp != null) {
			updateEmp = empService.queryByUsername(updateEmp.getUsername());
		}
		return SecurityComponent.isAuthority(emp, updateEmp);
	}

}
