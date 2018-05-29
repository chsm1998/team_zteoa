package com.three.zteoa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Position;
import com.three.zteoa.service.PositionService;
import com.three.zteoa.vo.DeleteVo;

@RestController
@RequestMapping("/position")
public class PositionController {

	@Autowired
	private PositionService positionService;

	@RequestMapping("/queryList")
	public List<Position> queryList(Integer currPage, Position position) {
		if (currPage == null) {
			currPage = 1;
		}
		return positionService.queryList(currPage, position);
	}

	@RequestMapping("/update")
	public boolean update(Position position) {
		return positionService.update(position);
	}

	@RequestMapping("/add")
	public boolean add(Position position) {
		return positionService.add(position);
	}

	@RequestMapping("/delete")
	public DeleteVo delete(Integer id) {
		return positionService.delete(id);
	}
	
	@RequestMapping("/queryAll")
	public List<Position> queryAll() {
		return positionService.queryAll();
	}

}
