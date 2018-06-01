package com.three.zteoa.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.three.zteoa.myenum.AgreeEnum;

/**
 * @author Vintonsen_lcx
 * @date 2018年5月29日
 * @time 上午8:53:53
 * @description :会议室申请
 * 
 */
public class BoardroomApply {

	private Integer id;// 主键id
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date start;// 开始时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date end;// 结束时间
	private Integer eid;// 申请人
	private Integer bid;// 申请会议室
	private Integer agree;// 审核进度
	private Date createTime;// 创建时间
	private Date modifyTime;// 修改时间
	private Emp emp;
	private Boardroom boardroom;

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

	public Integer getAgree() {
		return agree;
	}

	public void setAgree(Integer agree) {
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

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Boardroom getBoardroom() {
		return boardroom;
	}

	public void setBoardroom(Boardroom boardroom) {
		this.boardroom = boardroom;
	}

	@Override
	public String toString() {
		return "BoardroomApply [id=" + id + ", start=" + start + ", end=" + end + ", eid=" + eid + ", bid=" + bid
				+ ", agree=" + agree + ", createTime=" + createTime + ", modifyTime=" + modifyTime + ", emp=" + emp
				+ ", boardroom=" + boardroom + ", currPage=" + currPage + ", pageSize=" + pageSize + "]";
	}

}
