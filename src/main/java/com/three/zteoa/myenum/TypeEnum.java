package com.three.zteoa.myenum;

public enum TypeEnum {

	QUERY("查询", 1), DELETE("删除", 2), UDPATE("修改", 3), ADD("增加", 4);

	private String name;
	private Integer id;

	private TypeEnum(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

}
