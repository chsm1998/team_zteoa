package com.three.zteoa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.BoardroomApply;
import com.three.zteoa.bean.Emp;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月30日 
 * @time	下午3:18:08
 * @description :
 * 
 */
public interface BoardroomApplyService {
	
	// 添加办公室申请
	public boolean addBoardrommApply(BoardroomApply boardroomApply) throws Exception;
	
	// 删除办公室申请
	public boolean deleteBoardroomApply(@Param("id")Integer id) throws Exception;

	// 修改办公室申请
	public boolean modifyBoardroomApply(BoardroomApply boardroomApply) throws Exception;
	
	// 查询办公室申请列表
	public List<BoardroomApply> getBoardroomApplyList(BoardroomApply boardroomApply) throws Exception;
	
	// 根据id查询办公室申请
	public BoardroomApply getBoardroomApplyById(@Param("id")Integer id) throws Exception;

	// 查询办公室申请数量
	public int getCount(BoardroomApply boardroomApply) throws Exception;
	
	/**
	 * 获取所有申请列表
	 * @param eid 用户id
	 * @return
	 */
	List<BoardroomApply> getApplyByEid(Emp emp);
}
