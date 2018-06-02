package com.three.zetoa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Module;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.service.ModuleService;

public class ModuleTest extends BaseTest{
	
	@Autowired
	private ModuleService moduleService;
	
	@Test
	@Rollback(false)
	public void add() {
		ModuleEnum[] values = ModuleEnum.values();
		for (ModuleEnum moduleEnum : values) {
			moduleService.add(new Module(moduleEnum.getId(), moduleEnum.getName()));
		}
	}

	
}
