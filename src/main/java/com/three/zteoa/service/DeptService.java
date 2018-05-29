package com.three.zteoa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.three.zteoa.bean.Dept;
import com.three.zteoa.bean.DeptExample;
import com.three.zteoa.bean.EmpExample;
import com.three.zteoa.mapper.DeptMapper;
import com.three.zteoa.mapper.EmpMapper;
import com.three.zteoa.util.PageUtil;
import com.three.zteoa.util.ToBoolean;
import com.three.zteoa.vo.DeleteVo;

@Service
public class DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Autowired
	private EmpMapper empMapper;

	/**
	 * 添加部门
	 * 
	 * @param dept
	 * @return
	 */
	@Transactional
	public boolean add(Dept dept) {
		Date date = new Date();
		dept.setCreateTime(date);
		dept.setModifyTime(date);
		return ToBoolean.intToBool(deptMapper.insert(dept), 1);
	}

	/**
	 * 更新部门
	 * 
	 * @param dept
	 * @return
	 */
	@Transactional
	public boolean update(Dept dept) {
		dept.setModifyTime(new Date());
		return ToBoolean.intToBool(deptMapper.updateByPrimaryKeySelective(dept), 1);
	}

	/**
	 * 删除部门
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public DeleteVo delete(Integer id) {
		EmpExample empExample = new EmpExample();
		empExample.createCriteria().andDidEqualTo(id);
		if (empMapper.selectByExample(empExample).size() != 0) {
			return new DeleteVo("该部门存在员工禁止删除", false);
		}
		if (ToBoolean.intToBool(deptMapper.deleteByPrimaryKey(id), 1)) {
			return new DeleteVo("删除成功", true);
		}
		return new DeleteVo("服务器异常，删除失败", false);
	}

	/**
	 * 分页查询
	 * 
	 * @param currPage
	 * @param dept
	 * @return
	 */
	@Transactional
	public List<Dept> queryList(Integer currPage, Integer pageSize, Dept dept) {
		PageHelper.startPage(currPage == null ? 1 : currPage, pageSize == null ? 5 : pageSize);
		DeptExample example = null;
		if (dept != null && dept.getName() != null && !dept.getName().equals("")) {
			example = new DeptExample();
			example.createCriteria().andNameLike("%" + dept.getName() + "%");
		}
		return deptMapper.selectByExample(example);
	}

	@Transactional
	public long queryTotal(Dept dept) {
		DeptExample example = new DeptExample();
		if (dept != null && dept.getName() != null && !dept.getName().equals("")) {
			example.createCriteria().andNameLike("%" + dept.getName() + "%");
		}
		return deptMapper.countByExample(example);
	}

	public boolean queryByName(String name) {
		DeptExample example = new DeptExample();
		example.createCriteria().andNameEqualTo(name);
		return ToBoolean.intToBool(deptMapper.selectByExample(example).size(), 0);
	}

	/**
	 * 查询所有部门
	 * 
	 * @return
	 */
	@Transactional
	public List<Dept> queryAll() {
		return deptMapper.selectByExample(null);
	}

}
