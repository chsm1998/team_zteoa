package com.three.zetoa.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.EmpService;

public class TestEnum extends BaseTest{

	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private EmpService empService;
	
	@Test
	public void test() {
//		Emp emp = empService.queryByUsername("admin");
//		System.out.println(emp);
//		System.out.println(securityComponent.isAuthorityUpdateEmp(empService.queryByUsername("1"), empService.queryByUsername("1"), TypeEnum.QUERY));
	}

}
