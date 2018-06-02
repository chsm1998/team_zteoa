package com.three.zetoa.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.Module;
import com.three.zteoa.bean.Position;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.ModuleService;
import com.three.zteoa.service.PositionService;

public class AuthorityTest extends BaseTest {

	@Autowired
	private AuthorityService authorityService;
	@Autowired
	private PositionService positionService;
	@Autowired
	private ModuleService moduleService;

	/**
	 * 初始化权限
	 */
	@Test
	@Rollback(false)
	public void add() {
		List<Position> positions = positionService.queryAll();
		List<Module> modules = moduleService.queryAll();
		modules.forEach(module -> {
			positions.forEach(position -> {
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
		});
	}
	
	@Test
	public void queryAll() {
		authorityService.queryAll().forEach(authority -> {
			System.out.println("所属模块：" + ModuleEnum.getNameById(authority.getModuleId()));
		});;
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
