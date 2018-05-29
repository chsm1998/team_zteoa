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
		EmpExample example = new EmpExample();
		example.createCriteria().andUsernameEqualTo(username);
		return empMapper.selectByExample(example).get(0);
	}

	/**
	 * 注册
	 * 
	 * @param emp
	 * @return true：成功，false：失败
	 */
	public boolean register(Emp emp) {
		Date time = new Date();
		emp.setCreateTime(time);
		emp.setModifyTime(time);
		return empMapper.insert(emp) == 1;
	}

	/**
	 * 更新员工信息
	 * 
	 * @param emp
	 * @return
	 */
	public boolean update(Emp emp) {
		emp.setModifyTime(new Date());
		return ToBoolean.intToBool(empMapper.updateByPrimaryKeySelective(emp), 1);
	}

	/**
	 * 删除员工
	 * 
	 * @param id
	 * @return
	 */
	public boolean delete(Integer id) {
		return ToBoolean.intToBool(empMapper.deleteByPrimaryKey(id), 1);
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
		List<Dept> depts = deptMapper.selectByExample(null);
		List<Position> positions = positionMapper.selectByExample(null);
		for (Emp emp2 : emps) {
			for (Dept dept : depts) {
				if (emp2.getDid().equals(dept.getId())) {
					emp2.setDept(dept);
				}
			}
			for (Position position : positions) {
				if (emp2.getPid().equals(position.getId())) {
					emp2.setPosition(position);
				}
			}
		}
		return emps;
	}

}
