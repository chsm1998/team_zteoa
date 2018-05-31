package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Receive;
import com.three.zteoa.service.ReceiveService;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月31日 
 * @time	上午8:52:44
 * @description :
 * 
 */
@RestController
@RequestMapping("/receive")
public class ReceiveController {

	@Resource
	private ReceiveService receiveSeivice;
	
	@RequestMapping("/add")
	// 添加办公用品申请 
	public boolean addReceive(Receive receive) throws Exception{
		return receiveSeivice.addReceive(receive);
	}
		
	@RequestMapping("/delete")
	// 通过申请id，删除申请
	public boolean deleteReceivesById(@Param("receive")Integer receive_id) throws Exception{
		return receiveSeivice.deleteReceivesById(receive_id);
	}
	
	@RequestMapping("/modify")
	// 修改办公用品申请信息
	public boolean modifyReceive(Receive receive) throws Exception{
		return receiveSeivice.modifyReceive(receive);
	}
	
	@RequestMapping("queryById")
	// 通过条件查询-ReceiveList
	public List<Receive> getReceiveById(@Param("eid")Integer eid,@Param("pid")Integer pid
			,@Param("category")String category,@Param("currenPageNo")Integer currentPageNo,
			@Param("pageSize")Integer pageSize ) throws Exception{
		return receiveSeivice.getReceiveById(eid, pid, category, currentPageNo, pageSize);
	}
	
	@RequestMapping("/count")
	// 通过条件查询-记录数查询
	public int getReceiveCount(@Param("id")Integer id,@Param("category")String category) throws Exception{
		return receiveSeivice.getReceiveCount(id, category);
	}
	
	@RequestMapping("queryAll")
	// 查询办公用品申请列表
	public List<Receive> getReceiveList(Receive receive) throws Exception{
		return receiveSeivice.getReceiveList(receive);
	}

}
