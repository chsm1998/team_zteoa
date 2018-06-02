package com.three.zteoa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.three.zteoa.bean.Dept;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.EmpExample;
import com.three.zteoa.bean.Position;
import com.three.zteoa.mapper.DeptMapper;
import com.three.zteoa.mapper.EmpMapper;
import com.three.zteoa.mapper.PositionMapper;
import com.three.zteoa.util.PageUtil;
import com.three.zteoa.util.ToBoolean;
import com.three.zteoa.vo.UpdateVo;

@Service
@Transactional
public class EmpService {

	@Autowired
	private EmpMapper empMapper;
	@Autowired
	private DeptMapper deptMapper;
	@Autowired
	private PositionMapper positionMapper;

	/**
	 * 登录
	 * 
	 * @param emp
	 * @return true:成功,false：失败
	 */
	public boolean login(Emp emp) {
		EmpExample example = new EmpExample();
		example.createCriteria().andUsernameEqualTo(emp.getUsername()).andPasswordEqualTo(emp.getPassword());
		return empMapper.selectByExample(example).size() != 0;
	}

	/**
	 * 判断是否注册
	 * 
	 * @param username
	 * @return
	 */
	public boolean isRegister(String username) {
		EmpExample example = new EmpExample();
		example.createCriteria().andUsernameEqualTo(username);
		return empMapper.selectByExample(example).size() != 0;
	}

	/**
	 * 通过用户名获取员工信息
	 * 
	 * @param username
	 * @return
	 */
	public Emp queryByUsername(String username) {
		Emp emp = new Emp();
		emp.setUsername(username);
		return getEmps(emp).get(0);
	}

	/**
	 * 注册
	 * 
	 * @param emp
	 * @return true：成功，false：失败
	 */
	public UpdateVo register(Emp emp) {
		Date time = new Date();
		emp.setCreateTime(time);
		emp.setModifyTime(time);
		UpdateVo updateVo = new UpdateVo("添加失败，服务器异常", false);
		if (empMapper.insert(emp) == 1) {
			updateVo = new UpdateVo("添加成功", true);
		}
		return updateVo;
	}

	/**
	 * 更新员工信息
	 * 
	 * @param emp
	 * @return
	 */
	public UpdateVo update(Emp emp) {
		emp.setModifyTime(new Date());
		UpdateVo updateVo = new UpdateVo("更新员工信息失败", false);
		if (empMapper.updateByPrimaryKeySelective(emp) == 1) {
			updateVo = new UpdateVo("更新员工信息成功", true);
		}
		return updateVo;
	}

	/**
	 * 删除员工
	 * 
	 * @param id
	 * @return
	 */
	public UpdateVo delete(Integer id) {
		if (empMapper.deleteByPrimaryKey(id) == 1) {
			return new UpdateVo("删除成功", true);
		}
		return new UpdateVo("删除失败，服务器异常", false);
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 */
	public List<Emp> queryAll(Integer currPage, Integer pageSize, Emp emp) {
		if (currPage == null) {
			currPage = 1;
		}
		if (pageSize == null) {
			pageSize = 5;
		}
		PageHelper.startPage(currPage, pageSize);
		return getEmps(emp);
	}

	/**
	 * 获取总记录数
	 * 
	 * @param emp
	 * @return
	 */
	public long getCount(Emp emp) {
		return empMapper.countByExample(getEmpExample(emp));
	}

	/**
	 * 获取总页数
	 * 
	 * @param emp
	 * @return
	 */
	public long getPage(Emp emp) {
		return PageUtil.getPage(getCount(emp));
	}

	/**
	 * 获取EmpExample
	 * 
	 * @param emp
	 * @return
	 */
	private EmpExample getEmpExample(Emp emp) {
		if (emp == null) {
			return null;
		}
		EmpExample empExample = new EmpExample();
		EmpExample.Criteria criteria = empExample.createCriteria();
		if (emp.getUsername() != null && !emp.getUsername().equals("")) {
			criteria.andUsernameLike(PageUtil.getLike(emp.getUsername()));
		}
		if (emp.getName() != null && !emp.getName().equals("")) {
			criteria.andNameLike(PageUtil.getLike(emp.getName()));
		}
		return empExample;
	}

	private List<Emp> getEmps(Emp emp) {
		List<Emp> emps = empMapper.selectByExample(getEmpExample(emp));
		for (Emp emp2 : emps) {
			emp2.setDept(deptMapper.selectByPrimaryKey(emp2.getDid()));
			emp2.setPosition(positionMapper.selectByPrimaryKey(emp2.getPid()));
		}
		return emps;
	}
	
	public Emp queryById(Integer id) {
		Emp emp = empMapper.selectByPrimaryKey(id);
		emp.setDept(deptMapper.selectByPrimaryKey(emp.getDid()));
		emp.setPosition(positionMapper.selectByPrimaryKey(emp.getPid()));
		return emp;
	}

}
