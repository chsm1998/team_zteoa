package com.three.zteoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.AuthorityExample;
import com.three.zteoa.bean.AuthorityExample.Criteria;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Module;
import com.three.zteoa.bean.Position;
import com.three.zteoa.mapper.AuthorityMapper;
import com.three.zteoa.mapper.ModuleMapper;
import com.three.zteoa.mapper.PositionMapper;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.vo.AuthorityVo;

@Service
@Transactional
public class AuthorityService {

	@Autowired
	private AuthorityMapper authorityMapper;
	@Autowired
	private PositionMapper positionMapper;
	@Autowired
	private ModuleMapper moduleMapper;

	public boolean add(Authority authority) {
		Date time = new Date();
		authority.setCreateTime(time);
		authority.setModifyTime(time);
		return authorityMapper.insertSelective(authority) == 1;
	}

	public boolean update(Authority authority) {
		authority.setModifyTime(new Date());
		return authorityMapper.updateByPrimaryKeySelective(authority) == 1;
	}

	public boolean delete(Integer id) {
		return authorityMapper.deleteByPrimaryKey(id) == 1;
	}

	/**
	 * 判断当前模块下的角色是否有对应权限
	 * 
	 * @param emp
	 *            用户用于获取角色
	 * @param module
	 *            模块
	 * @param typeEnum
	 *            权限
	 * @return
	 */
	public boolean queryByEmpAndModule(Emp emp, ModuleEnum moduleEnum, TypeEnum typeEnum) {
		AuthorityExample authorityExample = new AuthorityExample();
		authorityExample.createCriteria().andPidEqualTo(emp.getPid()).andModuleIdEqualTo(moduleEnum.getId())
				.andTypeEqualTo(typeEnum.getId());
		return authorityMapper.selectByExample(authorityExample).get(0).getAuthority();
	}

	public List<Authority> queryByEmpAndModule(Emp emp, ModuleEnum moduleEnum) {
		AuthorityExample authorityExample = new AuthorityExample();
		Criteria createCriteria = authorityExample.createCriteria();
		System.out.println(emp);
		if (emp.getPid() != null) {
			createCriteria.andPidEqualTo(emp.getPid());
		}
		createCriteria.andModuleIdEqualTo(moduleEnum.getId());
		return authorityMapper.selectByExample(authorityExample);
	}
	
	public List<Authority> queryByEmpAndModule(Integer pid, Integer mid) {
		AuthorityExample authorityExample = new AuthorityExample();
		authorityExample.createCriteria().andPidEqualTo(pid).andModuleIdEqualTo(mid);
		return authorityMapper.selectByExample(authorityExample);
	}

	public List<Authority> queryAll() {
		return authorityMapper.selectByExample(null);
	}

}
