package com.three.zteoa.vo;

/**
 * 更新返回视图对象
 * @author chsm
 * @date 2018年6月2日
 */
public class UpdateVo {

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

	public UpdateVo(String message, boolean bl) {
		super();
		this.message = message;
		this.bl = bl;
	}

	@Override
	public String toString() {
		return "UpdateVo [message=" + message + ", bl=" + bl + "]";
	}

}
