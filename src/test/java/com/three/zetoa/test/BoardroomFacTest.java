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
	//会议设施add测试
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
	@Test
	//会议设施列表查询
	public void Test2() throws Exception {
		boardroomFacService.getBorardroomFacList(0, 0, 0, 5).forEach(System.out::println);
	}
	@Test
	//会议设施update测试
	public void Test3() {
		BoardroomFacilities boardroomFacilties = new BoardroomFacilities();
		boolean flag = false;
		boardroomFacilties.setNum(25);
		boardroomFacilties.setModifyTime(new Date());
		try {
			flag = boardroomFacService.updateBoardroomFac(boardroomFacilties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(flag);
	}
	@Test
	//会议设施delete测试
	public void test4() throws Exception {
		boolean flag = false;
		int id = 3;
		flag = boardroomFacService.deleteBoardroomFac(id);
		System.out.println(flag);
	}
	@Test
	//会议设施id查询
	public void test5() {
		BoardroomFacilities boardroomFacilties = new BoardroomFacilities();
		try {
			boardroomFacilties = boardroomFacService.getBoardroomFacById(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(boardroomFacilties.getPid()+boardroomFacilties.getBid()+boardroomFacilties.getNum());
	}
	@Test
	//会议设施count测试
	public void test6() throws Exception {
		int result = 0;
		result = boardroomFacService.getBorardroomFacCount(0, 0);
		System.err.println(result);
	}
}
