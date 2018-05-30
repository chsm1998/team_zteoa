package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.BoardroomFacilities;
import com.three.zteoa.service.BoardroomFacService;

@RestController
@RequestMapping("/boardroomFac")
public class BoardroomFacController {
	@Resource
	private BoardroomFacService boardroomFacService;

	// 会议设施列表
	@RequestMapping("/boardroomFacList.html")
	public List<BoardroomFacilities> getBorardroomFacList(Model model, @RequestParam(value = "pid", required = false) int pid,
			@RequestParam(value = "bid", required = false) int bid,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) throws Exception {
		int currentPageNo = 0;
		int pageSize = 5;
		return boardroomFacService.getBorardroomFacList(pid, bid, currentPageNo, pageSize);
	}

	// 增加会议设施
	@RequestMapping(value = "/boardroomfacaddsave.html", method = RequestMethod.POST)
	public Object addboardroomFacSave(BoardroomFacilities boardroomFacilities) throws Exception {
		boolean flag = false;
		flag = boardroomFacService.addBoardroomFac(boardroomFacilities);
		return flag;
	}

	// 修改会议设施
	@RequestMapping(value = "/boardroomupdatefacsave.html", method = RequestMethod.POST)
	public Object updateboardroomFacSave(BoardroomFacilities boardroomFacilities) throws Exception {
		boolean flag = false;
		flag = boardroomFacService.updateBoardroomFac(boardroomFacilities);
		return flag;
	}

	// 删除会议设施
	@RequestMapping(value = "/boardroomdeletefac.html", method = RequestMethod.GET)
	public Object deleteboardroomFac(@RequestParam Integer id) throws Exception {
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

}
