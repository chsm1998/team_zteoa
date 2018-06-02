package com.three.zteoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.vo.UpdateVo;

@RestController
public class AuthorityController {
	
	@Autowired
	private AuthorityService authorityService;
	
	public UpdateVo update(@RequestBody List<Authority> authorities) {
		
		return null;
	}
	
}
