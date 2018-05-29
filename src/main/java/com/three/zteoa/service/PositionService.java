package com.three.zteoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.three.zteoa.bean.EmpExample;
import com.three.zteoa.bean.Position;
import com.three.zteoa.bean.PositionExample;
import com.three.zteoa.mapper.EmpMapper;
import com.three.zteoa.mapper.PositionMapper;
import com.three.zteoa.util.PageUtil;
import com.three.zteoa.util.ToBoolean;
import com.three.zteoa.vo.DeleteVo;

@Service
@Transactional
public class PositionService {

	@Autowired
	private PositionMapper positionMapper;

	@Autowired
	private EmpMapper empMapper;

	/**
	 * 添加职位
	 * 
	 * @param position
	 * @return
	 */
	public boolean add(Position position) {
		return ToBoolean.intToBool(positionMapper.insert(position), 1);
	}

	/**
	 * 更新职位
	 * 
	 * @param position
	 * @return
	 */
	public boolean update(Position position) {
		return ToBoolean.intToBool(positionMapper.updateByPrimaryKeySelective(position), 1);
	}

	/**
	 * 删除职位
	 * 
	 * @param id
	 * @return
	 */
	public DeleteVo delete(Integer id) {
		EmpExample example = new EmpExample();
		example.createCriteria().andPidEqualTo(id);
		if (empMapper.selectByExample(example) != null) {
			return new DeleteVo("该职务下存在在职人员禁止删除", false);
		}
		if (ToBoolean.intToBool(positionMapper.deleteByPrimaryKey(id), 1)) {
			return new DeleteVo("删除成功", true);
		}
		return new DeleteVo("删除失败，服务器异常", false);
	}

	/**
	 * 分页查询
	 * 
	 * @param currPage
	 * @param position
	 * @return
	 */
	public List<Position> queryList(int currPage, Position position) {
		PageHelper.startPage(currPage, PageUtil.pageSize);
		PositionExample example = new PositionExample();
		if (position.getName() != null) {
			example.createCriteria().andNameEqualTo(position.getName());
		}
		return positionMapper.selectByExample(example);
	}

	/**
	 * 查询所有职务
	 * 
	 * @return
	 */
	public List<Position> queryAll() {
		return positionMapper.selectByExample(null);
	}

}
