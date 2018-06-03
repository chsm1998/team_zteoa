package com.three.zteoa.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.BoardroomApply;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.mapper.BoardroomApplyMapper;
import com.three.zteoa.service.BoardroomApplyService;
import com.three.zteoa.vo.UpdateVo;
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
	public UpdateVo addBoardrommApply(BoardroomApply boardroomApply) throws Exception {
		boardroomApply.setAgree(1);
		Date date = new Date();
		boardroomApply.setCreateTime(date);
		boardroomApply.setModifyTime(date);
		if (boardroomApplyMapper.addBoardroomApply(boardroomApply)) {
			return new UpdateVo("添加申请成功", true);
		}
		return new UpdateVo("添加申请失败，服务器异常", false);
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
	public int getCount(BoardroomApply boardroomApply) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		result = boardroomApplyMapper.getBorardroomApplyCount(boardroomApply);
		return result;
	}

	@Override
	public List<BoardroomApply> getBoardroomApplyList(BoardroomApply boardroomApply)
			throws Exception {
		// TODO Auto-generated method stub
		List<BoardroomApply> boardroomApplyList = new ArrayList<BoardroomApply>();
		boardroomApply.setCurrPage((boardroomApply.getCurrPage() - 1) * boardroomApply.getPageSize());
		boardroomApplyList = boardroomApplyMapper.getBorardroomApplyList(boardroomApply);
		return boardroomApplyList;
	}

	@Override
	public List<BoardroomApply> getApplyByEid(Emp emp) {
		return boardroomApplyMapper.getApplyByEid(emp);
	}

	@Override
	public boolean isTime(BoardroomApply boardroomApply) {
		if (boardroomApplyMapper.isTime(boardroomApply).size() == 0) {
			return true;
		}
		return false;
	}

}
