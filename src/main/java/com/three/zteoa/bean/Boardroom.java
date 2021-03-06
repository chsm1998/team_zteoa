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
	private Date createTime; // 创建时间
	private Date modifyTime; // 修改时间

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
		return "Boardroom [id=" + id + ", name=" + name + ", address=" + address + ", use=" + use + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", currPage=" + currPage + ", pageSize=" + pageSize + "]";
	}

}
