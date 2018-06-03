package com.three.zteoa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Position;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.PositionService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/position")
@CrossOrigin
public class PositionController {

	@Autowired
	private PositionService positionService;
	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/queryList")
	public List<Position> queryList(@RequestBody Position position) {
		return positionService.queryList(position.getCurrPage(), position.getPageSize(), position);
	}

	@RequestMapping("/update")
	public UpdateVo update(@RequestBody Position position, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.POSITION_MANAGER, TypeEnum.UDPATE);
		if (updateVo.isBl()) {
			if (positionService.update(position)) {
				return new UpdateVo("更新角色成功", true);
			}
			return new UpdateVo("更新角色失败，服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/add")
	public UpdateVo add(@RequestBody Position position, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.POSITION_MANAGER, TypeEnum.ADD);
		if (updateVo.isBl()) {
			if (positionService.add(position)) {
				return new UpdateVo("添加角色成功", true);
			}
			return new UpdateVo("添加角色失败，服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/delete")
	public UpdateVo delete(Integer id, HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.POSITION_MANAGER, TypeEnum.DELETE);
		if (updateVo.isBl()) {
			return positionService.delete(id);
		}
		return updateVo;
	}

	@RequestMapping("/queryAll")
	public List<Position> queryAll() {
		return positionService.queryAll();
	}

	@RequestMapping("/queryByName")
	public boolean queryByName(String name) {
		return !positionService.queryByName(name);
	}

	@RequestMapping("/queryTotal")
	public long getCount(@RequestBody Position position) {
		return positionService.getCount(position);
	}
	
	@RequestMapping("/getAuthoritys")
	public List<Authority> getAuthoritys(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return authorityService.queryByEmpAndModule(emp, ModuleEnum.POSITION_MANAGER);
	}

}
