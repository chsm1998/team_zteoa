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

import com.three.zteoa.bean.Boardroom;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.service.BoardroomService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/boardroom")
public class BoardroomController extends BaseController {
	@Resource
	private BoardroomService boardroomService;

	// 会议室列表
	@RequestMapping("/queryList")
	public List<Boardroom> getBorardroomList(@RequestBody Boardroom boardroom) {
		return boardroomService.getBorardroomList(boardroom);
	}

	// 增加会议室
	@RequestMapping("/add")
	public boolean addboardroomSave(@RequestBody Boardroom boardroom) throws Exception {
		return boardroomService.addBoardroom(boardroom);
	}

	// 修改会议室
	@RequestMapping("/update")
	public boolean updateboardroomSave(@RequestBody Boardroom boardroom) throws Exception {
		return boardroomService.updateBoardroom(boardroom);
	}

	// 删除会议室
	@RequestMapping("/delete")
	public Object deleteboardroom(Integer id) throws Exception {
		return boardroomService.deleteBoardroom(id);
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
	
	/**
	 * 鉴权
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/isAuthority")
	public UpdateVo isAuthority(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return SecurityComponent.isAuthorityProduct(emp);
	}
	
	@RequestMapping("/queryTotal")
	public int queryTotal(Boardroom boardroom) {
		return boardroomService.getBorardroomCount(boardroom.getName(), null);
	}
	

}
