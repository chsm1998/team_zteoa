package com.three.zteoa.bean;

import java.util.Date;

/**
 * @author	Vintonsen_lcx
 * @date	2018年5月29日 
 * @time	上午8:44:22
 * @description :办公用品申请
 * 
 */
public class Receive {

	private Integer id;//主键id
	private Integer eid;//申请人id
	private Integer pid;//商品id
	private Integer num;//申请数量
	private String category;//申请类别
	private String reason;//申请原因
	private Date create_time;//申请时间
	private Date modify_time;//修改时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
