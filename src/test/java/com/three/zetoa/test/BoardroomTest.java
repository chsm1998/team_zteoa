package com.three.zetoa.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Boardroom;
import com.three.zteoa.service.BoardroomService;

@Rollback(false)
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

	@Test
	public void boardroomTest2() throws Exception{
//		boardroomService.getBorardroomList(null,null,0,5).forEach(System.out::println);;		
	}
	
	@Test
	public void boardroomTest3() throws Exception{
		boolean flag = false;
		flag = boardroomService.deleteBoardroom(1);
		System.out.println(flag);
	}

	@Test
	public void boardroomTest4() throws Exception{
		Boardroom boardroom = new Boardroom();
		int id  = 3;
		boardroom = boardroomService.getBoardroomById(id);
		System.out.println(boardroom);
	}
	@Test
	public void test5() {
		Boardroom boardroom = new Boardroom();
		boolean flag = false;
		boardroom.setName("纯净苍穹");
		boardroom.setModifyTime(new Date());
		try {
			flag = boardroomService.updateBoardroom(boardroom);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
	}
	@Test
	public void test6() throws Exception {
		Boardroom boardroom = new Boardroom();
		String name = "虚空行者";
		boardroom = boardroomService.getBoardroomName(name);
		System.out.println(boardroom);
	}
}
