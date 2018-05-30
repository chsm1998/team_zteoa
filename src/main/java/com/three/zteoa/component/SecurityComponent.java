package com.three.zteoa.component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.myenum.OperationEnum;
import com.three.zteoa.myenum.PositionEnum;
import com.three.zteoa.vo.UpdateVo;

/**
 * 
 * @author chsm
 * @date 2018年5月30日
 */
public class SecurityComponent {

	private static Map<String, List<String>> authority;
	private static final String NOT_AUTHORITY = "权限不足";
	public static final String EMP_UPDATE = OperationEnum.update.toString() + "emp";
	public static final String POSITION_UPDATE = OperationEnum.update.toString() + "position";
	public static final String DEPT_UPDATE = OperationEnum.update.toString() + "dept";

	static {
		String[] emp = { PositionEnum.manager.getName(), PositionEnum.generalmanager.getName() };
		String[] position = { PositionEnum.generalmanager.getName() };
		List<String> empUpdate = Arrays.asList(emp);
		List<String> positionUpdate = Arrays.asList(position);
		authority = new HashMap<>();
		authority.put(EMP_UPDATE, empUpdate);
		authority.put(POSITION_UPDATE, positionUpdate);
		authority.put(DEPT_UPDATE, positionUpdate);
	}

	public List<String> setAuthority(Integer title) {
		List<String> list = new ArrayList<>();
		PositionEnum[] positionEnums = PositionEnum.values();
		for (PositionEnum positionEnum : positionEnums) {
			if (positionEnum.getTitle() >= title) {
				list.add(positionEnum.getName());
			}
		}
		return list;
	}

	/**
	 * 鉴权
	 * 
	 * @param emp
	 *            执行人
	 * @param updateEmp
	 *            被执行人
	 * @return
	 */
	public static UpdateVo isAuthority(Emp emp, Emp updateEmp) {
		if (emp.getId() == 1) {
			return new UpdateVo("验证通过", true);
		}
		if (updateEmp.getId() == 1) {
			return new UpdateVo("禁止删除系统管理员", false);
		}
		if (updateEmp == null || updateEmp.getPosition() == null) {
			if (isAuthority(emp, EMP_UPDATE)) {
				return new UpdateVo("验证通过", true);
			}
			return new UpdateVo(NOT_AUTHORITY, false);
		}
		if (!isAuthority(emp, EMP_UPDATE)) {
			return new UpdateVo(NOT_AUTHORITY, false);
		}
		String name = emp.getPosition().getName();
		String updateName = updateEmp.getPosition().getName();
		Integer title = getTitle(name);
		Integer updateTitle = getTitle(updateName);
		if (title == null) {
			return new UpdateVo(NOT_AUTHORITY, false);
		}
		if (updateTitle == null) {
			return new UpdateVo("验证通过", true);
		}
		if (updateTitle != null && title > updateTitle) {
			return new UpdateVo("验证通过", true);
		}
		return new UpdateVo(NOT_AUTHORITY, false);
	}

	public static UpdateVo isUpdateAuthority(Emp emp, String type) {
		if (emp.getId() == 1) {
			return new UpdateVo("验证通过", true);
		}
		String name = emp.getPosition().getName();
		Integer title = getTitle(name);
		Integer updateTitle = getTitle(type);
		if (updateTitle == null) {
			return new UpdateVo("验证通过", true);
		}
		if (title > updateTitle) {
			return new UpdateVo("验证通过", true);
		}
		return new UpdateVo(NOT_AUTHORITY, false);
	}

	public static UpdateVo isAuthorityDept(Emp emp) {
		if (isAuthority(emp, DEPT_UPDATE)) {
			return new UpdateVo("验证通过", true);
		}
		return new UpdateVo("权限不足", false);
	}

	public static UpdateVo isAuthorityPosition(Emp emp) {
		if (isAuthority(emp, POSITION_UPDATE)) {
			return new UpdateVo("验证通过", true);
		}
		return new UpdateVo("权限不足", false);
	}

	/**
	 * 获取职位等级
	 * 
	 * @param name
	 * @return
	 */
	private static Integer getTitle(String name) {
		if (name == null) {
			return null;
		}
		PositionEnum[] positionEnums = PositionEnum.values();
		for (PositionEnum positionEnum : positionEnums) {
			if (name.equals(positionEnum.getName())) {
				return positionEnum.getTitle();
			}
		}
		return null;
	}

	/**
	 * 判断权限
	 * 
	 * @param emp
	 * @return
	 */
	private static boolean isAuthority(Emp emp, String type) {
		String name = emp.getPosition().getName();
		return authority.get(type).contains(name);
	}

}
