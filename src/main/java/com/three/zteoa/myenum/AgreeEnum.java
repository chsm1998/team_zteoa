package com.three.zteoa.myenum;

public enum AgreeEnum {

	CHECK_PENDING("待审核", 1), CHECK_SUCCESS("审核通过", 2), CHECK_ERROR("审核未通过", 3);

	private String state;
	private Integer code;

	private AgreeEnum(String state, Integer code) {
		this.state = state;
		this.code = code;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
