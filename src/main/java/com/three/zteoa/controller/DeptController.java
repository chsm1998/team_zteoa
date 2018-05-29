package com.three.zteoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Dept;
import com.three.zteoa.service.DeptService;
import com.three.zteoa.vo.DeleteVo;

@RestController
@RequestMapping("/dept")
public class DeptController {

	@Autowired
	private DeptService deptService;

	@RequestMapping("/queryList")
	public List<Dept> queryList(@RequestBody(required = false) Dept dept) {
		return deptService.queryList(dept.getCurrPage(), dept.getPageSize(), dept);
	}

	@RequestMapping("/queryAll")
	public List<Dept> queryAll() {
		return deptService.queryAll();
	}

	@RequestMapping("/update")
	public boolean update(@RequestBody Dept dept) {
		return deptService.update(dept);
	}

	@RequestMapping("/add")
	public boolean add(@RequestBody Dept dept) {
		return deptService.add(dept);
	}

	@RequestMapping("/delete")
	public DeleteVo delete(Integer id) {
		return deptService.delete(id);
	}

	@RequestMapping("/queryTotal")
	public long queryTotal(@RequestBody Dept dept) {
		return deptService.queryTotal(dept);
	}

	@RequestMapping("/queryByName")
	public boolean queryByName(String name) {
		return deptService.queryByName(name);
	}

}
