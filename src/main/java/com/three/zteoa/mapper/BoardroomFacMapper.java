package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.BoardroomFacilities;

/**
 * 会议设施
 * @author bin
 *
 */
public interface BoardroomFacMapper {
	// 增加会议设施
	public boolean addBoardroomFac(BoardroomFacilities boardroomFacilties) throws Exception;

	// 会议设施的数量
	public int getBorardroomFacCount(@Param("pid") int pid,@Param("bid") int bid) throws Exception;

	// 会议设施的列表查询
	public List<BoardroomFacilities> getBorardroomFacList(@Param("pid") int pid, @Param("bid") int bid,
			@Param("currentPageNo") int currentPageNo, @Param("pageSize") int pageSize) throws Exception;

	// 会议设施的删除
	public boolean deleteBoardroomFac(@Param("id") int id) throws Exception;

	// 会议设施的修改
	public boolean updateBoardroomFac(BoardroomFacilities boardroomFacilties) throws Exception;

	// 根据id查询会议设施
	public BoardroomFacilities getBoardroomFacById(@Param("id") int id) throws Exception;

}
