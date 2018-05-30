package com.three.zteoa.bean;

import java.util.Date;

/**
 * 会议室设施
 * 
 * @author bin
 */
public class BoardroomFacilities {
	private Integer id;//
	private Integer pid; // 设施id,与用品表外键关联
	private Integer num; // 设施数量
	private Integer bid;// 所属会议室
	private Date createTime; // 创建时间
	private Date modifyTime; // 修改时间
	private String zBroomName; //会议室名称
	private String zProductName;//商品名称
	
	public String getzBroomName() {
		return zBroomName;
	}

	public String getzProductName() {
		return zProductName;
	}

	public void setzBroomName(String zBroomName) {
		this.zBroomName = zBroomName;
	}

	public void setzProductName(String zProductName) {
		this.zProductName = zProductName;
	}

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

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
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

}
