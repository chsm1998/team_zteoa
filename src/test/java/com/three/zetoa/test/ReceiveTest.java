package com.three.zetoa.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Receive;
import com.three.zteoa.service.ReceiveService;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月31日 
 * @time	上午11:01:56
 * @description :办公用品申请测试
 * 
 */
@Rollback(false)
public class ReceiveTest extends BaseTest{

	@Autowired
	private ReceiveService receiveService;
	
	@Test
	public void addTest() throws Exception{
		try {
			Receive receive = new Receive();
			receive.setId(1);
			receive.setEid(1);
			receive.setPid(1);
			receive.setNum(50);
			receive.setCategory("桌面用品");
			receive.setReason("办公");
			receive.setCreateTime(new Date());
			receiveService.addReceive(receive);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void deleteTest() throws Exception{
		try {
			receiveService.deleteReceivesById(1);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void modifyTest() throws Exception{
		try {
			Receive receive = new Receive();
			receive.setId(2);
			receive.setEid(2);
			receive.setPid(2);
			receive.setNum(30);
			receive.setCategory("办公本簿");
			receive.setReason("书写");
			receive.setModifyTime(new Date());
			receiveService.modifyReceive(receive);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryAllTest() throws Exception{
		try {
			Receive receive = new Receive();
			receiveService.getReceiveList(receive);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryByIdTest() throws Exception{
		try {
			receiveService.getReceiveById(2, 2,"办公本簿" , 0, 5);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void countTest() throws Exception{
		try {
			receiveService.getReceiveCount(2, "办公本簿");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
