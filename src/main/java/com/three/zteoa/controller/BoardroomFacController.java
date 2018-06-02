package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.BoardroomFacilities;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.service.BoardroomFacService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/boardroomFacilities")
public class BoardroomFacController {
	@Resource
	private BoardroomFacService boardroomFacService;

	// 会议设施列表
	@RequestMapping("/queryList")
	public List<BoardroomFacilities> getBorardroomFacList(@RequestBody BoardroomFacilities boardroomFacilities) {
		return boardroomFacService.getBorardroomFacList(boardroomFacilities);
	}

	// 增加会议设施
	@RequestMapping("/add")
	public Object addboardroomFacSave(@RequestBody BoardroomFacilities boardroomFacilities) throws Exception {
		boolean flag = false;
		flag = boardroomFacService.addBoardroomFac(boardroomFacilities);
		return flag;
	}

	// 修改会议设施
	@RequestMapping("/update")
	public Object updateboardroomFacSave(@RequestBody BoardroomFacilities boardroomFacilities) throws Exception {
		boolean flag = false;
		flag = boardroomFacService.updateBoardroomFac(boardroomFacilities);
		return flag;
	}

	// 删除会议设施
	@RequestMapping("/delete")
	public Object deleteboardroomFac(Integer id) throws Exception {
		boolean flag = false;
		flag = boardroomFacService.deleteBoardroomFac(id);
		return flag;
	}

	// 会议设施据id查询
	@RequestMapping(value = "/boardroomfacview", method = RequestMethod.GET)
	@ResponseBody
	public Object viewfac(@RequestParam int id) throws Exception {
		return boardroomFacService.getBoardroomFacById(id);
	}
	
	@RequestMapping("/queryTotal")
	public int queryTotal(@RequestBody(required = false) BoardroomFacilities boardroomFacilities) {
		return boardroomFacService.getBorardroomFacCount(null, boardroomFacilities.getBid());
	}

}
