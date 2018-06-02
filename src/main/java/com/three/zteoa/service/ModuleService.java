package com.three.zteoa.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.three.zteoa.bean.Module;
import com.three.zteoa.bean.ModuleExample;
import com.three.zteoa.mapper.ModuleMapper;

@Service
@Transactional
public class ModuleService {
	
	@Autowired
	private ModuleMapper moduleMapper;
	
	/**
	 * 添加模块
	 * @param module
	 * @return
	 */
	public int add(Module module) {
		Date time = new Date();
		module.setCreateTime(time);
		module.setModifyTime(time);
		return moduleMapper.insertSelective(module);
	}

	/**
	 * 查询所有模块
	 * @return
	 */
	public List<Module> queryAll() {
		return moduleMapper.selectByExample(null);
	}
	
	/**
	 * 通过moduleId查询module
	 * @param moduleId
	 * @return
	 */
	public Module queryByModuleId(Integer moduleId) {
		ModuleExample example = new ModuleExample();
		example.createCriteria().andModuleIdEqualTo(moduleId);
		return moduleMapper.selectByExample(example).get(0);
	}
	
}
