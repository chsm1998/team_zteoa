package com.three.zteoa.vo;

public class DeleteVo {

	private String message;
	private boolean bl;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isBl() {
		return bl;
	}

	public void setBl(boolean bl) {
		this.bl = bl;
	}

	public DeleteVo(String message, boolean bl) {
		super();
		this.message = message;
		this.bl = bl;
	}

}
