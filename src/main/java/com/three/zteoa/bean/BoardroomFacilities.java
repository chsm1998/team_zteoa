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
	private String zBroomName; // 会议室名称
	private String zProductName;// 商品名称

	private Integer currPage;
	private Integer pageSize;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
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

	public String getzBroomName() {
		return zBroomName;
	}

	public void setzBroomName(String zBroomName) {
		this.zBroomName = zBroomName;
	}

	public String getzProductName() {
		return zProductName;
	}

	public void setzProductName(String zProductName) {
		this.zProductName = zProductName;
	}

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

	@Override
	public String toString() {
		return "BoardroomFacilities [id=" + id + ", pid=" + pid + ", num=" + num + ", bid=" + bid + ", createTime="
				+ createTime + ", modifyTime=" + modifyTime + ", zBroomName=" + zBroomName + ", zProductName="
				+ zProductName + ", currPage=" + currPage + ", pageSize=" + pageSize + "]";
	}

}
