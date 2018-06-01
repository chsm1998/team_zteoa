package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Receive;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月29日 
 * @time	上午9:48:58
 * @description :receive的mapper接口。
 * 
 */
public interface ReceiveMapper {

	// 添加办公用品申请 
	public boolean addReceive(Receive receive) throws Exception;
	
	// 通过申请id，删除申请
	public boolean deleteReceivesById(@Param("receive")Integer receive_id) throws Exception;
	
	// 修改办公用品申请信息
	public boolean modifyReceive(Receive receive);
	
	// 通过条件查询-ReceiveList
	public List<Receive> getReceiveById(Receive receive) throws Exception;
	
	// 通过条件查询-记录数查询
	public int getReceiveCount(Receive receive) throws Exception;

	// 查询办公用品申请列表
	public List<Receive> getReceiveList(Receive receive) throws Exception;
	
	Receive queryById(Receive receive);
}
