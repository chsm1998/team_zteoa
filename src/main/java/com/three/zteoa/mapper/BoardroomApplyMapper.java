package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.BoardroomApply;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月30日 
 * @time	下午2:25:31
 * @description :办公室申请
 * 
 */
public interface BoardroomApplyMapper {

	// 添加办公室申请
	public boolean addBoardrommApply(BoardroomApply boardroomApply) throws Exception;
	
	// 删除办公室申请
	public boolean deleteBoardroomApply(@Param("id")Integer id) throws Exception;

	// 修改办公室申请
	public boolean modifyBoardroomApply(BoardroomApply boardroomApply) throws Exception;
	
	// 查询办公室申请列表
	public List<BoardroomApply> getBoardroomApplyList(BoardroomApply boardroomApply,@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize) throws Exception;
	
	// 根据id查询办公室申请
	public BoardroomApply getBoardroomApplyById(@Param("id")Integer id) throws Exception;

	// 查询办公室申请数量
	public int getCount(@Param("id")Integer id,@Param("is_agree")boolean is_agree) throws Exception;
}
