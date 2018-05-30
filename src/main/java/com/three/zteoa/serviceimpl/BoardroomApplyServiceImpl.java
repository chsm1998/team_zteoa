package com.three.zteoa.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.BoardroomApply;
import com.three.zteoa.mapper.BoardroomApplyMapper;
import com.three.zteoa.service.BoardroomApplyService;
/**
 * @author	Vintonsen_lcx
 * @date	2018年5月30日 
 * @time	下午3:58:02
 * @description :
 * 
 */
@Service
public class BoardroomApplyServiceImpl implements BoardroomApplyService{
	@Resource
	private BoardroomApplyMapper boardroomApplyMapper;
	@Override
	public boolean addBoardrommApply(BoardroomApply boardroomApply) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomApplyMapper.addBoardrommApply(boardroomApply);
		return flag;
	}

	@Override
	public boolean deleteBoardroomApply(Integer id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomApplyMapper.deleteBoardroomApply(id);
		return flag;
	}

	@Override
	public boolean modifyBoardroomApply(BoardroomApply boardroomApply) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		flag = boardroomApplyMapper.modifyBoardroomApply(boardroomApply);
		return flag;
	}


	@Override
	public BoardroomApply getBoardroomApplyById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		BoardroomApply boardroomApply = null;
		boardroomApply = boardroomApplyMapper.getBoardroomApplyById(id);
		return boardroomApply;
	}

	@Override
	public int getCount(Integer id, boolean is_agree) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = boardroomApplyMapper.getCount(id, is_agree);
		return result;
	}

	@Override
	public List<BoardroomApply> getBoardroomApplyList(BoardroomApply boardroomApply, int currentPageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardroomApply> boardroomApplyList = new ArrayList<BoardroomApply>();
		currentPageNo = (currentPageNo - 1) * pageSize;
		boardroomApplyList = boardroomApplyMapper.getBoardroomApplyList(boardroomApply, currentPageNo, pageSize);
		return boardroomApplyList;
	}

}
