package com.three.zteoa.bean;

import java.util.Date;

public class Dept {
	private Integer id;

	private String name;

	private Date createTime;

	private Date modifyTime;

	private Integer currPage;

	private Integer pageSize;

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

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

	public Dept(String name, Date time) {
		super();
		this.name = name;
		this.createTime = time;
		this.modifyTime = time;
	}

	public Dept() {
		super();
	}

	@Override
	public String toString() {
		return "Dept [id=" + id + ", name=" + name + ", createTime=" + createTime + ", modifyTime=" + modifyTime
				+ ", currPage=" + currPage + ", pageSize=" + pageSize + "]";
	}

}