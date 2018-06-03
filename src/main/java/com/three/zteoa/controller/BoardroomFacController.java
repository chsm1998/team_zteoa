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
import com.three.zteoa.bean.BoardroomFacilities;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.BoardroomFacService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/boardroomFacilities")
public class BoardroomFacController {
	@Resource
	private BoardroomFacService boardroomFacService;
	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private AuthorityService authorityService;

	// 会议设施列表
	@RequestMapping("/queryList")
	public List<BoardroomFacilities> getBorardroomFacList(@RequestBody BoardroomFacilities boardroomFacilities) {
		return boardroomFacService.getBorardroomFacList(boardroomFacilities);
	}

	// 增加会议设施
	@RequestMapping("/add")
	public UpdateVo addboardroomFacSave(@RequestBody BoardroomFacilities boardroomFacilities, HttpSession session)
			throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.BOARDROOM_PRODUCT_MANAGER,
				TypeEnum.ADD);
		if (updateVo.isBl()) {
			if (boardroomFacService.addBoardroomFac(boardroomFacilities)) {
				return new UpdateVo("添加会议设施成功", true);
			}
			return new UpdateVo("添加会议设施失败，服务器异常", false);
		}
		return updateVo;
	}

	// 修改会议设施
	@RequestMapping("/update")
	public UpdateVo updateboardroomFacSave(@RequestBody BoardroomFacilities boardroomFacilities, HttpSession session)
			throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.BOARDROOM_PRODUCT_MANAGER,
				TypeEnum.UDPATE);
		if (updateVo.isBl()) {
			if (boardroomFacService.updateBoardroomFac(boardroomFacilities)) {
				return new UpdateVo("修改会议设施成功", true);
			}
			return new UpdateVo("修改会议设施失败，服务器异常", false);
		}
		return updateVo;
	}

	// 删除会议设施
	@RequestMapping("/delete")
	public UpdateVo deleteboardroomFac(Integer id, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.BOARDROOM_PRODUCT_MANAGER,
				TypeEnum.DELETE);
		if (updateVo.isBl()) {
			if (boardroomFacService.deleteBoardroomFac(id)) {
				return new UpdateVo("删除会议设施成功", true);
			}
			return new UpdateVo("删除会议设施失败，服务器异常", false);
		}
		return updateVo;
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
	
	@RequestMapping("/getAuthoritys")
	public List<Authority> getAuthoritys(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return authorityService.queryByEmpAndModule(emp, ModuleEnum.BOARDROOM_PRODUCT_MANAGER);
	}

}
