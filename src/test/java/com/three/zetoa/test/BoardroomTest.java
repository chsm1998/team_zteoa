package com.three.zetoa.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Boardroom;
import com.three.zteoa.service.BoardroomService;


public class BoardroomTest extends BaseTest{
	
	@Autowired
	private BoardroomService boardroomService;
	
	@Test
	public void boardroomTest() throws Exception {
		Boardroom boardroom = new Boardroom();
		boolean flag = false;
		boardroom.setName("霸者重装");
		boardroom.setAddress("Hui_10");
		boardroom.setUse(true);
		boardroom.setCreateTime(new Date());
		
		flag = boardroomService.addBoardroom(boardroom);
		System.out.println(flag);
	}
	@Rollback(false)
	@Test
	public void boardroomTest2(){
		List<Boardroom> boardlist = new ArrayList<Boardroom>();
		
	}
}
