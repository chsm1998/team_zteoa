package com.three.zteoa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.Dept;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.DeptService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;
	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/queryList")
	public List<Dept> queryList(@RequestBody(required = false) Dept dept) {
		return deptService.queryList(dept.getCurrPage(), dept.getPageSize(), dept);
	}

	@RequestMapping("/queryAll")
	public List<Dept> queryAll() {
		return deptService.queryAll();
	}

	@RequestMapping("/update")
	public UpdateVo update(@RequestBody Dept dept, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.DEPT_MANAGER, TypeEnum.UDPATE);
		if (updateVo.isBl()) {
			if (deptService.update(dept)) {
				return new UpdateVo("更新部门成功", true);
			}
			return new UpdateVo("更新部门失败,服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/add")
	public UpdateVo add(@RequestBody Dept dept, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.DEPT_MANAGER, TypeEnum.ADD);
		if (updateVo.isBl()) {
			if (deptService.add(dept)) {
				return new UpdateVo("添加部门成功", true);
			}
			return new UpdateVo("添加部门失败,服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/delete")
	public UpdateVo delete(Integer id, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.DEPT_MANAGER, TypeEnum.DELETE);
		if (updateVo.isBl()) {
			return deptService.delete(id);
		}
		return updateVo;
	}

	@RequestMapping("/queryTotal")
	public long queryTotal(@RequestBody Dept dept) {
		return deptService.queryTotal(dept);
	}

	@RequestMapping("/queryByName")
	public boolean queryByName(String name) {
		return deptService.queryByName(name);
	}

	@RequestMapping("/getAuthoritys")
	public List<Authority> getAuthoritys(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return authorityService.queryByEmpAndModule(emp, ModuleEnum.DEPT_MANAGER);
	}

}
