package com.three.zteoa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.three.zteoa.bean.BoardroomFacilities;
import com.three.zteoa.mapper.BoardroomFacMapper;
import com.three.zteoa.service.BoardroomFacService;
@Service
public class BoardroomFacServiceImpl implements BoardroomFacService{
	@Resource
	private BoardroomFacMapper boardroomFacMapper;
	@Override
	public boolean addBoardroomFac(BoardroomFacilities boardroomFacilties) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomFacMapper.addBoardroomFac(boardroomFacilties);
		return flag;
	}

	@Override
	public int getBorardroomFacCount(int pid, int bid) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = boardroomFacMapper.getBorardroomFacCount(pid, bid);
		return result;
	}

	@Override
	public List<BoardroomFacilities> getBorardroomFacList(int pid, int bid, int currentPageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardroomFacilities> borardroomFacList = new ArrayList<BoardroomFacilities>();
		currentPageNo = (currentPageNo - 1) * pageSize;
		borardroomFacList = boardroomFacMapper.getBorardroomFacList(pid, bid, currentPageNo, pageSize);
		return borardroomFacList;
	}

	@Override
	public boolean deleteBoardroomFac(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomFacMapper.deleteBoardroomFac(id);
		return flag;
	}

	@Override
	public boolean updateBoardroomFac(BoardroomFacilities boardroomFacilties) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomFacMapper.updateBoardroomFac(boardroomFacilties);
		return flag;
	}

	@Override
	public BoardroomFacilities getBoardroomFacById(int id) throws Exception {
		// TODO Auto-generated method stub
		BoardroomFacilities boardroomFacilities = null;
		boardroomFacilities = boardroomFacMapper.getBoardroomFacById(id);
		return boardroomFacilities;
	}
	
}
