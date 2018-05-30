package com.three.zteoa.myenum;

/**
 * 
 * @author chsm
 * @date 2018年5月30日
 */
public enum PositionEnum {

	manager("部门经理", 3), staff("普通员工", 1), generalmanager("总经理", 4), cashier("财务", 2);

	private String name;
	private Integer title;

	private PositionEnum(String name, Integer title) {
		this.name = name;
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public Integer getTitle() {
		return title;
	}

}
