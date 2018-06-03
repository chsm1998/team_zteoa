package com.three.zteoa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.EmpExample;
import com.three.zteoa.bean.Module;
import com.three.zteoa.bean.Position;
import com.three.zteoa.bean.PositionExample;
import com.three.zteoa.mapper.EmpMapper;
import com.three.zteoa.mapper.PositionMapper;
import com.three.zteoa.myenum.TypeEnum;
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
	@Autowired
	private ModuleService moduleService;
	@Autowired
	private AuthorityService authorityService;

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
		int rank = 1;
		if (position.getName().contains("经理")) {
			rank = 2;
		}
		position.setRank(rank);
		boolean bl = positionMapper.insert(position) == 1;
		if (bl) {
			addAuthority(position);
		}
		return bl;
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
	
	private void addAuthority(Position position) {
		List<Module> modules = moduleService.queryAll();
		modules.forEach(module -> {
				boolean[] bls = null;
				if (position.getRank() == 1) {
					if (module.getId() == 8 || module.getId() == 9) {
						bls = new boolean[] { true, false, false, true };
					} else {
						bls = new boolean[] { true, false, false, false };
					}
				} else {
					if (module.getId() == 2 || module.getId() == 3) {
						if (position.getRank() == 3) {
							bls = new boolean[] { true, true, true, true };
						} else {
							bls = new boolean[] { true, false, false, false };
						}
					} else {
						bls = new boolean[] { true, true, true, true };
					}
				}
				getAuthoritys(module.getId(), position.getId(), bls).forEach(authority -> {
					authorityService.add(authority);
				});
		});
	}
	
	private List<Authority> getAuthoritys(Integer mid, Integer pid, boolean[] bls) {
		Authority query = new Authority(mid, pid, bls[0], TypeEnum.QUERY.getId());
		Authority update = new Authority(mid, pid, bls[1], TypeEnum.UDPATE.getId());
		Authority delete = new Authority(mid, pid, bls[2], TypeEnum.DELETE.getId());
		Authority add = new Authority(mid, pid, bls[3], TypeEnum.ADD.getId());
		List<Authority> authorities = new ArrayList<>();
		authorities.add(query);
		authorities.add(update);
		authorities.add(delete);
		authorities.add(add);
		return authorities;
	}

}
