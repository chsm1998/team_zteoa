package com.three.zteoa.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//商品类别表
public class ProductCategory {
	private Integer id;
	private String category; // 商品类别名称
	// 对日期格式的设置
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createTime; // 创建时间
	// 对日期格式的设置
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modifyTime; // 修改时间

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
