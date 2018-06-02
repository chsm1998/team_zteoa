package com.three.zetoa.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Position;
import com.three.zteoa.service.PositionService;

public class PositionTest extends BaseTest {

	@Autowired
	private PositionService positionService;

	@Test
	@Rollback(false)
	public void add() {
//		Position[] positions = { new Position("普通员工", new Date()), new Position("部门经理", new Date()),
//				new Position("总经理", new Date()), new Position("财务", new Date()) };
//		for (Position position : positions) {
//			positionService.add(position);
//		}
	}

}
