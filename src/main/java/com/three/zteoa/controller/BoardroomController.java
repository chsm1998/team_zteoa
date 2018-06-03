package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.Boardroom;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.BoardroomService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/boardroom")
public class BoardroomController {
	@Resource
	private BoardroomService boardroomService;
	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private AuthorityService authorityService;

	// 会议室列表
	@RequestMapping("/queryList")
	public List<Boardroom> getBorardroomList(@RequestBody Boardroom boardroom) {
		return boardroomService.getBorardroomList(boardroom);
	}

	// 增加会议室
	@RequestMapping("/add")
	public UpdateVo addboardroomSave(@RequestBody Boardroom boardroom, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.BOARDROOM_MANAGER, TypeEnum.ADD);
		if (updateVo.isBl()) {
			if (boardroomService.addBoardroom(boardroom)) {
				return new UpdateVo("添加会议室成功", true);
			}
			return new UpdateVo("添加会议室失败，服务器异常", false);
		}
		return updateVo;
	}

	// 修改会议室
	@RequestMapping("/update")
	public UpdateVo updateboardroomSave(@RequestBody Boardroom boardroom, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.BOARDROOM_MANAGER, TypeEnum.UDPATE);
		if (updateVo.isBl()) {
			if (boardroomService.updateBoardroom(boardroom)) {
				return new UpdateVo("修改会议室成功", true);
			}
			return new UpdateVo("修改会议室失败，服务器异常", false);
		}
		return updateVo;
	}

	// 删除会议室
	@RequestMapping("/delete")
	public UpdateVo deleteboardroom(Integer id, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.BOARDROOM_MANAGER, TypeEnum.DELETE);
		if (updateVo.isBl()) {
			if (boardroomService.deleteBoardroom(id)) {
				return new UpdateVo("删除会议室成功", true);
			}
			return new UpdateVo("删除会议室失败，服务器异常", false);
		}
		return updateVo;
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

	@RequestMapping("/queryTotal")
	public int queryTotal(Boardroom boardroom) {
		return boardroomService.getBorardroomCount(boardroom.getName(), null);
	}

	@RequestMapping("/queryAll")
	public List<Boardroom> queryAll() {
		return boardroomService.queryAll();
	}

	@RequestMapping("/getAuthoritys")
	public List<Authority> getAuthoritys(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return authorityService.queryByEmpAndModule(emp, ModuleEnum.BOARDROOM_MANAGER);
	}

}
