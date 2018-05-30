package com.three.zetoa.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.BoardroomFacilities;
import com.three.zteoa.service.BoardroomFacService;

@Rollback(false)
public class BoardroomFacTest extends BaseTest{
	@Autowired
	private BoardroomFacService boardroomFacService;
	@Test
	public void Test1() throws Exception {
		BoardroomFacilities boardroomFacilties = new BoardroomFacilities();
		boolean flag = false;
		boardroomFacilties.setPid(1);
		boardroomFacilties.setNum(25);
		boardroomFacilties.setBid(1);
		boardroomFacilties.setCreateTime(new Date());
		flag = boardroomFacService.addBoardroomFac(boardroomFacilties);
		System.out.println(flag);
	}
}
