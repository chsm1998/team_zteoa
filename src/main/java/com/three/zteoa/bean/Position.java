package com.three.zteoa.bean;

import java.util.Date;

public class Position {
	private Integer id;

	private String name;

	private Date createTime;

	private Date modifyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ "]";
	}

	public Position(String name, Date time) {
		super();
		this.name = name;
		this.createTime = time;
		this.modifyTime = time;
	}

	public Position() {
		super();
	}

}