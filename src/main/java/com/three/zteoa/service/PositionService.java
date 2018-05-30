package com.three.zteoa.service;

import java.util.Date;
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
import com.three.zteoa.vo.UpdateVo;

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
		Date date = new Date();
		position.setCreateTime(date);
		position.setModifyTime(date);
		return ToBoolean.intToBool(positionMapper.insert(position), 1);
	}
	
	public Position queryById(Integer id) {
		return positionMapper.selectByPrimaryKey(id);
	}

	/**
	 * 更新职位
	 * 
	 * @param position
	 * @return
	 */
	public boolean update(Position position) {
		position.setModifyTime(new Date());
		return ToBoolean.intToBool(positionMapper.updateByPrimaryKeySelective(position), 1);
	}

	/**
	 * 删除职位
	 * 
	 * @param id
	 * @return
	 */
	public UpdateVo delete(Integer id) {
		EmpExample example = new EmpExample();
		example.createCriteria().andPidEqualTo(id);
		if (empMapper.selectByExample(example).size() != 0) {
			return new UpdateVo("该职务下存在在职人员禁止删除", false);
		}
		if (ToBoolean.intToBool(positionMapper.deleteByPrimaryKey(id), 1)) {
			return new UpdateVo("删除成功", true);
		}
		return new UpdateVo("删除失败，服务器异常", false);
	}

	/**
	 * 分页查询
	 * 
	 * @param currPage
	 * @param position
	 * @return
	 */
	public List<Position> queryList(Integer currPage, Integer pageSize, Position position) {
		PageHelper.startPage(currPage == null ? 1 : currPage, pageSize == null ? 5 : pageSize);
		PositionExample example = new PositionExample();
		if (position != null && position.getName() != null && !position.getName().equals("")) {
			example.createCriteria().andNameLike("%" + position.getName() + "%");
		}
		return positionMapper.selectByExample(example);
	}

	/**
	 * 判断该职务是否存在
	 * 
	 * @param name
	 * @return
	 */
	public boolean queryByName(String name) {
		PositionExample example = new PositionExample();
		example.createCriteria().andNameEqualTo(name);
		return positionMapper.selectByExample(example).size() != 0;
	}

	/**
	 * 获取总记录数
	 * 
	 * @param position
	 * @return
	 */
	public long getCount(Position position) {
		PositionExample example = new PositionExample();
		if (position != null && position.getName() != null && !position.getName().equals("")) {
			example.createCriteria().andNameLike("%" + position.getName() + "%");
		}
		return positionMapper.countByExample(example);
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
