package com.three.zteoa.bean;

import java.util.Date;

/**
 * 会议室设施
 * @author bin
 */
public class BoardroomFacilities {
	private int id;//
	private int pid; //设施id,与用品表外键关联 
	private int num;  //设施数量
	private int bid;// 所属会议室
	private Date create_time; //创建时间
	private Date modify_time; //修改时间
	public int getId() {
		return id;
	}
	public int getPid() {
		return pid;
	}
	public int getNum() {
		return num;
	}
	public int getBid() {
		return bid;
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
	public void setPid(int pid) {
		this.pid = pid;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	
}
