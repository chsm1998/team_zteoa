package com.three.zteoa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.Boardroom;
import com.three.zteoa.mapper.BoardroomMapper;
import com.three.zteoa.service.BoardroomService;

@Service
public class BoardroomServiceImpl implements BoardroomService {
	@Resource
	private BoardroomMapper boardroomMapper;

	@Override
	public boolean addBoardroom(Boardroom boardroom) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomMapper.addBoardroom(boardroom);
		return flag;
	}

	@Override
	public int getBorardroomCount(String name, String address) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = boardroomMapper.getBorardroomCount(name, address);
		return result;
	}

	@Override
	public List<Boardroom> getBorardroomList(String name, String address, int currentPageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<Boardroom> borardroomList = new ArrayList<Boardroom>();
		currentPageNo = (currentPageNo - 1) * pageSize;
		borardroomList = boardroomMapper.getBorardroomList(name, address, currentPageNo, pageSize);
		return borardroomList;
	}

	@Override
	public boolean deleteBoardroom(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomMapper.deleteBoardroom(id);
		return flag;
	}

	@Override
	public boolean updateBoardroom(Boardroom boardroom) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomMapper.updateBoardroom(boardroom);
		return flag;
	}

	@Override
	public Boardroom getBoardroomById(int id) throws Exception {
		// TODO Auto-generated method stub
		Boardroom boardroom = null;
		boardroom = boardroomMapper.getBoardroomById(id);
		return boardroom;
	}

	@Override
	public Boardroom getBoardroomName(String name) throws Exception {
		Boardroom boardroom = null;
		boardroom = boardroomMapper.getBoardroomName(name);
		return boardroom;
	}

}
