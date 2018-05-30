package com.three.zteoa.bean;

import java.util.Date;

/**
 * 会议室
 * 
 * @author bin
 *
 */
public class Boardroom {
	private Integer id;//
	private String name; // 会议室名称
	private String address; // 会议室地址
	private Boolean use; // 是否使用
	private Date crateTime; // 创建时间
	private Date modifyTime; // 修改时间

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getUse() {
		return use;
	}

	public void setUse(Boolean use) {
		this.use = use;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getCrateTime() {
		return crateTime;
	}

	public void setCrateTime(Date crateTime) {
		this.crateTime = crateTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

}
