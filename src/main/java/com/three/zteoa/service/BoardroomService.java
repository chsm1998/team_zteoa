package com.three.zteoa.service;

import java.util.List;

import com.three.zteoa.bean.Boardroom;

public interface BoardroomService {
	// 增加会议室
	public boolean addBoardroom(Boardroom boardroom) throws Exception;

	// 会议室的数量
	public int getBorardroomCount(String name, String address) throws Exception;

	// 会议室的列表查询
	public List<Boardroom> getBorardroomList(String name, String address, int currentPageNo, int pageSize)
			throws Exception;

	// 会议室的删除
	public boolean deleteBoardroom(int id) throws Exception;

	// 会议室的修改
	public boolean updateBoardroom(Boardroom boardroom) throws Exception;

	// 根据id查询会议室
	public Boardroom getBoardroomById(int id) throws Exception;

	// 会议室名称的验证
	public Boardroom getBoardroomName(String name) throws Exception;
}
