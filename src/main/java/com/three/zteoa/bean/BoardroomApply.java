package com.three.zteoa.bean;

import java.util.Date;

/**
 * @author Vintonsen_lcx
 * @date 2018年5月29日
 * @time 上午8:53:53
 * @description :会议室申请
 * 
 */
public class BoardroomApply {

	private Integer id;// 主键id
	private Date start;// 开始时间
	private Date end;// 结束时间
	private Integer eid;//申请人
	private Boolean agree;// 是否同意
	private Date createTime;// 创建时间
	private Date modifyTime;// 修改时间

	
	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Boolean getAgree() {
		return agree;
	}

	public void setAgree(Boolean agree) {
		this.agree = agree;
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

}
