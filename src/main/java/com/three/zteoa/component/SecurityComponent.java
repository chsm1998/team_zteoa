package com.three.zteoa.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.vo.UpdateVo;

/**
 * 
 * @author chsm
 * @date 2018年5月30日
 */
@Component
public class SecurityComponent {

	@Autowired
	private AuthorityService authorityService;

	private static final UpdateVo NOT_AUTHORITY = new UpdateVo("权限不足", false);
	private static final UpdateVo SUCCESS = new UpdateVo("验证通过", true);

	/**
	 * 员工修改权限
	 * 
	 * @param currRank
	 * @param updateRank
	 * @return
	 */
	public UpdateVo isAuthorityUpdateEmp(Emp emp, Emp updateEmp, TypeEnum typeEnum) {
		System.out.println(updateEmp);
		if (updateEmp != null && updateEmp.getPid() == null) {
			return new UpdateVo("禁止修改系统管理员", false);
		}
		// 系统管理员放行
		if (emp.getPid() == null) {
			return SUCCESS;
		}
		// 验证是否有权限
		if (!authorityService.queryByEmpAndModule(emp, ModuleEnum.EMP_MANAGER, typeEnum)) {
			return NOT_AUTHORITY;
		}
		System.out.println(emp);
		System.out.println(updateEmp);
		// 验证权限等级
		if (emp.getPosition().getRank() > updateEmp.getPosition().getRank()) {
			return SUCCESS;
		}
		return NOT_AUTHORITY;
	}

	/**
	 * 验证其他更新权限
	 * 
	 * @param emp
	 * @param typeEnum
	 * @return
	 */
	public UpdateVo isAuthorityUpdate(Emp emp, ModuleEnum moduleEnum, TypeEnum typeEnum) {
		// 系统管理员放行
		if (emp.getPid() == null) {
			return SUCCESS;
		}
		if (!authorityService.queryByEmpAndModule(emp, moduleEnum, typeEnum)) {
			return NOT_AUTHORITY;
		}
		return SUCCESS;
	}

}
