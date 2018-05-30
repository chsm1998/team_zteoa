package com.three.zteoa.service;

import java.util.List;


import com.three.zteoa.bean.BoardroomFacilities;

public interface BoardroomFacService {
	// 增加会议设施
	public boolean addBoardroomFac(BoardroomFacilities boardroomFacilties) throws Exception;

	// 会议设施的数量
	public int getBorardroomFacCount(int pid,int bid) throws Exception;

	// 会议设施的列表查询
	public List<BoardroomFacilities> getBorardroomFacList(int pid, int bid,int currentPageNo,int pageSize) throws Exception;

	// 会议设施的删除
	public boolean deleteBoardroomFac(int id) throws Exception;

	// 会议设施的修改
	public boolean updateBoardroomFac(BoardroomFacilities boardroomFacilties) throws Exception;

	// 根据id查询会议设施
	public BoardroomFacilities getBoardroomFacById(int id) throws Exception;
}
