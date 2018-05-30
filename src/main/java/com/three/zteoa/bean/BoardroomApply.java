package com.three.zteoa.bean;

import java.util.Date;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月29日 
 * @time	上午8:53:53
 * @description :会议室申请
 * 
 */
public class BoardroomApply {

	private Integer id;//主键id
	private Date start;//开始时间
	private Date end;//结束时间
	private boolean is_agree;//是否同意
	private Date create_time;//创建时间
	private Date modify_time;//修改时间
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
	public boolean isIs_agree() {
		return is_agree;
	}
	public void setIs_agree(boolean is_agree) {
		this.is_agree = is_agree;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getModify_time() {
		return modify_time;
	}
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	
}
