package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Boardroom;
import com.three.zteoa.service.BoardroomService;

@RestController
public class BoardroomController extends BaseController {
	@Resource
	private BoardroomService boardroomService;

	// 会议室列表
	@RequestMapping("/boardroomList.html")
	public List<Boardroom> getBorardroomList(Model model, @RequestParam(value = "name", required = false) String name,
			@RequestParam(value = "address", required = false) String address,
			@RequestParam(value = "pageIndex", required = false) String pageIndex) throws Exception {
		int currentPageNo = 0;
		int pageSize = 5;
		return boardroomService.getBorardroomList(name, address, currentPageNo, pageSize);
	}

	// 增加会议室
	@RequestMapping(value = "/boardroomaddsave.html", method = RequestMethod.POST)
	public Object addboardroomSave(Boardroom boardroom) throws Exception {
		boolean flag = false;
		flag = boardroomService.addBoardroom(boardroom);
		return flag;
	}

	// 修改会议室
	@RequestMapping(value = "/boardroomupdatesave.html", method = RequestMethod.POST)
	public Object updateboardroomSave(Boardroom boardroom) throws Exception {
		boolean flag = false;
		flag = boardroomService.updateBoardroom(boardroom);
		return flag;
	}

	// 删除会议室
	@RequestMapping(value = "/boardroomdelete.html", method = RequestMethod.GET)
	public Object deleteboardroom(@RequestParam Integer id) throws Exception {
		boolean flag = false;
		flag = boardroomService.deleteBoardroom(id);
		return flag;
	}

	// 会议室据id查询
	@RequestMapping(value = "/boardroomview", method = RequestMethod.GET)
	@ResponseBody
	public Object view(@RequestParam int id) throws Exception {
		return boardroomService.getBoardroomById(id);
	}

	// 会议室名称的验证
	@RequestMapping(value = "/boardroomexit")
	@ResponseBody // 异步
	public Object userCodeIsExist(@RequestParam String name) throws Exception {
		return boardroomService.getBoardroomName(name);
	}
}
