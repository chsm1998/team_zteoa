package com.three.zteoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.service.EmpService;

@RestController
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;

	@PostMapping("/add")
	public boolean add(@RequestBody Emp emp) {
		return empService.register(emp);
	}

	@PostMapping("/update")
	public boolean update(@RequestBody Emp emp) {
		return empService.update(emp);
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
		System.out.println(emp);
		return empService.getCount(emp);
	}

	@RequestMapping("/isRegister")
	public boolean isRegister(String username) {
		return !empService.isRegister(username);
	}

}
