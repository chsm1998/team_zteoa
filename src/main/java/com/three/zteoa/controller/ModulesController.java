package com.three.zteoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Module;
import com.three.zteoa.service.ModuleService;

@RequestMapping("/modules")
@RestController
@CrossOrigin
public class ModulesController {
	
	@Autowired
	private ModuleService moduleService;
	
	@RequestMapping("/queryAll")
	public List<Module> queryAll() {
		return moduleService.queryAll();
	}
	
}
