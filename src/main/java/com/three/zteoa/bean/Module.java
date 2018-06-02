package com.three.zteoa.bean;

import java.util.Date;

public class Module {
	private Integer id;

	private Integer moduleId;

	private String moduleName;

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

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName == null ? null : moduleName.trim();
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

	public Module(Integer moduleId, String moduleName) {
		super();
		this.moduleId = moduleId;
		this.moduleName = moduleName;
	}

	public Module() {
		super();
	}

	@Override
	public String toString() {
		return "Module [id=" + id + ", moduleId=" + moduleId + ", moduleName=" + moduleName + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + "]";
	}

}