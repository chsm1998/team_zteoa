package com.three.zteoa.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Position;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.service.PositionService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/position")
public class PositionController {

	@Autowired
	private PositionService positionService;

	@RequestMapping("/queryList")
	public List<Position> queryList(@RequestBody Position position) {
		return positionService.queryList(position.getCurrPage(), position.getPageSize(), position);
	}

	@RequestMapping("/update")
	public boolean update(@RequestBody Position position) {
		return positionService.update(position);
	}

	@RequestMapping("/add")
	public boolean add(@RequestBody Position position) {
		return positionService.add(position);
	}

	@RequestMapping("/delete")
	public UpdateVo delete(Integer id) {
		return positionService.delete(id);
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

	@RequestMapping("/isAuthority")
	public UpdateVo isAuthority(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return SecurityComponent.isAuthorityPosition(emp);
	}

}
