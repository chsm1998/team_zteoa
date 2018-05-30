package com.three.zetoa.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.three.zteoa.bean.Boardroom;
import com.three.zteoa.service.BoardroomService;
import com.three.zteoa.service.BoardroomServiceImpl;


public class BoardroomTest extends BaseTest{
	
	@Autowired
	private BoardroomService boardroomService;
	
	@Test
	public void boardroomTest() throws Exception {
		Boardroom boardroom = new Boardroom();
		boolean flag = false;
		boardroom.setName("霸者重装");
		boardroom.setAddress("Hui_10");
		boardroom.setIs_user(0);
		boardroom.setCrate_time(new Date());
		
		flag = boardroomService.addBoardroom(boardroom);
		System.out.println(flag);
	}
}
