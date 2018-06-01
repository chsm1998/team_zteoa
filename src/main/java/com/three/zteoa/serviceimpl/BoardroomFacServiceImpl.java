package com.three.zteoa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.three.zteoa.bean.BoardroomFacilities;
import com.three.zteoa.mapper.BoardroomFacMapper;
import com.three.zteoa.service.BoardroomFacService;

@Service
public class BoardroomFacServiceImpl implements BoardroomFacService {
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
	public int getBorardroomFacCount(Integer pid, Integer bid){
		// TODO Auto-generated method stub
		int result = 0;
		result = boardroomFacMapper.getBorardroomFacCount(pid, bid);
		return result;
	}

	@Override
	public List<BoardroomFacilities> getBorardroomFacList(BoardroomFacilities boardroomFacilities) {
		// TODO Auto-generated method stub
		boardroomFacilities.setCurrPage((boardroomFacilities.getCurrPage() - 1) * boardroomFacilities.getPageSize());
		return boardroomFacMapper.getBorardroomFacList(boardroomFacilities);
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
