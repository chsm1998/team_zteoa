package com.three.zetoa.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Dept;
import com.three.zteoa.service.DeptService;

public class DeptTest extends BaseTest {

	@Autowired
	private DeptService deptService;

	@Test
	@Rollback(false)
	public void add() {
		Dept[] depts = { new Dept("人事部", new Date()), new Dept("平台研发部", new Date()), new Dept("产品设计部", new Date()),
				new Dept("财务部", new Date()), new Dept("总裁办公室部", new Date()) };
		for (Dept dept : depts) {
			deptService.add(dept);
		}
	}
	
	@Test
	public void query() {
//		deptService.queryList(1, null);
	}

}
