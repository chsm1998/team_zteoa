package com.three.zteoa.bean;

import java.util.Date;
/**
 * 会议室
 * @author bin
 *
 */
public class Boardroom {
	private Integer id;//
	private String name; //会议室名称
	private String address; //会议室地址
	private int is_user; //是否使用
	private Date crate_time; //创建时间
	private Date modify_time; //修改时间
	
	public Date getCrate_time() {
		return crate_time;
	}
	public void setCrate_time(Date crate_time) {
		this.crate_time = crate_time;
	}
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getIs_user() {
		return is_user;
	}
	
	public Date getModify_time() {
		return modify_time;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setIs_user(int is_user) {
		this.is_user = is_user;
	}
	
	public void setModify_time(Date modify_time) {
		this.modify_time = modify_time;
	}
	
}
