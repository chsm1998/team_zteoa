package com.three.zteoa.bean;

import java.util.Date;

public class Authority {
	private Integer id;

	private Integer moduleId;

	private Integer pid;

	private Boolean authority;

	private Integer type;

	private Date createTime;

	private Date modifyTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModuleId() {
		return moduleId;
	}

	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Boolean getAuthority() {
		return authority;
	}

	public void setAuthority(Boolean authority) {
		this.authority = authority;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Authority(Integer moduleId, Integer pid, Boolean authority, Integer type) {
		super();
		this.moduleId = moduleId;
		this.pid = pid;
		this.authority = authority;
		this.type = type;
	}

	public Authority() {
		super();
	}

	@Override
	public String toString() {
		return "Authority [id=" + id + ", moduleId=" + moduleId + ", pid=" + pid + ", authority=" + authority
				+ ", type=" + type + ", createTime=" + createTime + ", modifyTime=" + modifyTime + "]";
	}

}