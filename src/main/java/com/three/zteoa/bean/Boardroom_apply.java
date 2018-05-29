package com.three.zteoa.bean;

import java.util.Date;

/**
 * 会议室申请表
 * @author bin
 *
 */
public class Boardroom_apply {
	private int id;
	private Date start; //开始时间
	private Date end;  //结束时间
	private int eid;  //申请人
	private Date create_time;//创建时间
	private Date modify_time;//修改时间
	public int getId() {
		return id;
	}
	public Date getStart() {
		return start;
	}
	public Date getEnd() {
		return end;
	}
	public int getEid() {
		return eid;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	
}
