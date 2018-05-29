package com.three.zetoa.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.service.EmpService;

public class EmpTest extends BaseTest{
	
	@Autowired
	private EmpService empService;
	
	@Test
	@Rollback(false)
	public void register() {
		Emp emp = new Emp();
		emp.setName("系统管理员");
		emp.setUsername("admin");
		emp.setPassword("admin");
		emp.setPhone("13479379346");
		emp.setAddress("江西省南昌市天祥大道388号");
		emp.setPid(3);
		emp.setDid(5);
		Date date = new Date();
		emp.setCreateTime(date);
		emp.setModifyTime(date);
		empService.register(emp);
	}
	
	@Test
	public void queryAll() {
		Emp emp = new Emp();
		emp.setName("");
		System.out.println(empService.getCount(emp));
	}

}
