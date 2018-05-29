package com.three.zteoa.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//商品类别表
public class ProductCategory {
	private Integer id;		
	private String category;	//商品类别名称
	//对日期格式的设置
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_time;   //创建时间
	//对日期格式的设置
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modify_time;	//修改时间
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
