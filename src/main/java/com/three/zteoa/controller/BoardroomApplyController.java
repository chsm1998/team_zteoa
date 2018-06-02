package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.BoardroomApply;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.BoardroomApplyService;
import com.three.zteoa.vo.UpdateVo;

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
	@Autowired
	private SecurityComponent securityComponent;
	
	
	@RequestMapping("/add")
	// 添加办公室申请
	public UpdateVo addBoardrommApply(@RequestBody BoardroomApply boardroomApply, HttpSession session) throws Exception{
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, TypeEnum.ADD);
		if (updateVo.isBl()) {
			boardroomApply.setEid(emp.getId());
			return boardroomApplyService.addBoardrommApply(boardroomApply);
		}
		return updateVo;
	}
	
	@RequestMapping("/delete")
	// 删除办公室申请
	public boolean deleteBoardroomApply(@Param("id")Integer id) throws Exception{
		return boardroomApplyService.deleteBoardroomApply(id);
	}

	@RequestMapping("/update")
	// 修改办公室申请
	public boolean modifyBoardroomApply(@RequestBody BoardroomApply boardroomApply) throws Exception{
		return boardroomApplyService.modifyBoardroomApply(boardroomApply);
	}
	
	@RequestMapping("/queryList")
	// 查询办公室申请列表
	public List<BoardroomApply> getBoardroomApplyList(@RequestBody BoardroomApply boardroomApply) throws Exception{
		if (boardroomApply == null) {
			boardroomApply = new BoardroomApply();
		}
		return boardroomApplyService.getBoardroomApplyList(boardroomApply);
	}
	
	@RequestMapping("/queryById")
	// 根据id查询办公室申请
	public BoardroomApply getBoardroomApplyById(@Param("id")Integer id) throws Exception{
		return boardroomApplyService.getBoardroomApplyById(id);
	}

	@RequestMapping("/queryTotal")
	// 查询办公室申请数量
	public int getCount(@RequestBody BoardroomApply boardroomApply) throws Exception{
		return boardroomApplyService.getCount(boardroomApply);
	}
	
	/**
	 * 所有申请列表
	 * @return
	 */
	@RequestMapping("/getAllApply")
	public List<BoardroomApply> getAllApply(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return boardroomApplyService.getApplyByEid(emp);
	}

}
