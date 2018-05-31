package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.BoardroomApply;
import com.three.zteoa.service.BoardroomApplyService;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月31日 
 * @time	上午8:25:13
 * @description :办公室申请控制器
 * 
 */
@RestController
@RequestMapping("/boardroomApply")
public class BoardroomApplyController{

	@Resource
	private BoardroomApplyService boardroomApplyService;
	
	
	@RequestMapping("/add")
	// 添加办公室申请
	public boolean addBoardrommApply(BoardroomApply boardroomApply) throws Exception{
		return boardroomApplyService.addBoardrommApply(boardroomApply);
	}
	
	@RequestMapping("/delete")
	// 删除办公室申请
	public boolean deleteBoardroomApply(@Param("id")Integer id) throws Exception{
		return boardroomApplyService.deleteBoardroomApply(id);
	}

	@RequestMapping("/modify")
	// 修改办公室申请
	public boolean modifyBoardroomApply(BoardroomApply boardroomApply) throws Exception{
		return boardroomApplyService.modifyBoardroomApply(boardroomApply);
	}
	
	@RequestMapping("/queryAll")
	// 查询办公室申请列表
	public List<BoardroomApply> getBoardroomApplyList(BoardroomApply boardroomApply,@Param("currentPageNo")int currentPageNo,@Param("pageSize")int pageSize) throws Exception{
		return boardroomApplyService.getBoardroomApplyList(boardroomApply, currentPageNo, pageSize);
	}
	
	@RequestMapping("/queryById")
	// 根据id查询办公室申请
	public BoardroomApply getBoardroomApplyById(@Param("id")Integer id) throws Exception{
		return boardroomApplyService.getBoardroomApplyById(id);
	}

	@RequestMapping("/count")
	// 查询办公室申请数量
	public int getCount(@Param("id")Integer id,@Param("is_agree")boolean is_agree) throws Exception{
		return boardroomApplyService.getCount(id, is_agree);
	}

}
