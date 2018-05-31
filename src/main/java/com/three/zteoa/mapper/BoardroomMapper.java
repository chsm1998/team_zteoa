package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Boardroom;

/**
 * 会议室
 * 
 * @author bin
 *
 */
public interface BoardroomMapper {
	// 增加会议室
	public boolean addBoardroom(Boardroom boardroom) throws Exception;

	// 会议室的数量
	public int getBorardroomCount(@Param("name") String name, @Param("address") String address);

	// 会议室的列表查询
	public List<Boardroom> getBorardroomList(Boardroom boardroom);

	// 会议室的删除
	public boolean deleteBoardroom(@Param("id") int id) throws Exception;

	// 会议室的修改
	public boolean updateBoardroom(Boardroom boardroom) throws Exception;

	// 根据id查询会议室
	public Boardroom getBoardroomById(@Param("id") int id) throws Exception;

	// 会议室名称的验证
	public Boardroom getBoardroomName(@Param("name") String name) throws Exception;
}
