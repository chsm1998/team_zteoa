package com.three.zteoa.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/authority")
@CrossOrigin
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;
	
//	public UpdateVo update(@RequestBody List<Authority> authorities) {
//		
//		return null;
//	}
	
//	public List<Authority> queryByPid(Integer pid) {
//		
//	}
	@RequestMapping("/queryAll")
	public List<Authority> queryAll() {
		return authorityService.queryAll();
	}
	
	@RequestMapping("/queryByEmpAndModule")
	public List<Authority> queryByEmpAndModule(@RequestBody Map<String, Integer> map) {
		return authorityService.queryByEmpAndModule(map.get("pid"), map.get("mid"));
	}
	
}
