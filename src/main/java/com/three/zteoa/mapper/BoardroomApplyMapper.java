package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.BoardroomApply;

public interface BoardroomApplyMapper {
	//会议列表
	public List<BoardroomApply> getBoardroomApplyList(@Param("is_agree")int is_agree,@Param("eid")int eid,@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize)throws Exception;
	//会议的数量
	public int getBoardroomApplyCount(@Param("is_aggree")int is_aggree,@Param("eid")int eid)throws Exception;
	//会议的增加
	public boolean addBoardroomApply(BoardroomApply boardroomApply)throws Exception;
	//会议的删除
	public boolean deleteBoardroomApply(@Param("id")int id)throws Exception;
	//会议的
}
