package com.three.zetoa.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.BoardroomApply;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.service.BoardroomApplyService;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月31日 
 * @time	上午10:34:50
 * @description :会议室申请测试类
 * 
 */
@Rollback(false)
public class BoardroomApplyTest extends BaseTest{

	@Autowired
	private BoardroomApplyService boardroomApplyService;
	
	@Test
	public void addTest() throws Exception{
		BoardroomApply boardroomApply = new BoardroomApply();
		boolean flag = false;
		boardroomApply.setId(111);
		Date a = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-05-31 16:00");
		boardroomApply.setStart(a);
		Date b = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-05-31 18:00");
 		boardroomApply.setEnd(b);
 		boardroomApply.setCreateTime(new Date());
 		boardroomApply.setAgree(true);
 		boardroomApply.setEid(1);
 		flag = boardroomApplyService.addBoardrommApply(boardroomApply);
 		System.out.println(flag);
	}
	
	@Test
	public void deleteTest() throws Exception{
	
		boolean flag = false;
		flag = boardroomApplyService.deleteBoardroomApply(1);
	}
	
	@Test
	public void modifyTest() throws Exception{
		BoardroomApply boardroomApply = new BoardroomApply();
		boolean flag = false;
		boardroomApply.setId(111);
		Date a = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-06-31 16:00");
		boardroomApply.setStart(a);
		Date b = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("2018-06-31 18:00");
 		boardroomApply.setEnd(b);
 		boardroomApply.setAgree(true);
 		boardroomApply.setEid(1);
 		boardroomApply.setModifyTime(new Date());
 		flag = boardroomApplyService.modifyBoardroomApply(boardroomApply);
 		System.out.println(flag);
		
	}
	
	@Test
	public void queryAllTest() throws Exception{

		try {
			boardroomApplyService.getBoardroomApplyList(null,0,5).forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void queryByIdTest() throws Exception{
		try {
			boardroomApplyService.getBoardroomApplyById(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void countTest() throws Exception{
		try {
			boardroomApplyService.getCount(1, true);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
