package com.three.zteoa.myenum;

public enum ModuleEnum {

	EMP_MANAGER("员工管理", 1), 
	DEPT_MANAGER("部门管理", 2), 
	POSITION_MANAGER("角色管理", 3),
	PRODUCT_MANAGER("用品管理", 4), 
	PRODUCT_TYPE_MANAGER("用品类别管理", 5), 
	BOARDROOM_MANAGER("会议室管理", 6),
	BOARDROOM_PRODUCT_MANAGER("会议设施管理", 7),
	PRODUCT_APPLY("用品审批", 8),
	BOARDROOM_APPLY("会议审批", 9),
	;

	private String name;
	private Integer id;
	
	private ModuleEnum(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}
	
	public static String getNameById(Integer id) {
		ModuleEnum[] values = ModuleEnum.values();
		for (ModuleEnum moduleEnum : values) {
			if (moduleEnum.getId() == id) {
				return moduleEnum.getName();
			}
		}
		return null;
	}
	
	public static ModuleEnum getModuleEnumById(Integer id) {
		ModuleEnum[] values = ModuleEnum.values();
		for (ModuleEnum moduleEnum : values) {
			if (moduleEnum.getId() == id) {
				return moduleEnum;
			}
		}
		return null;
	}

}
