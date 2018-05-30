package com.three.zteoa.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//商品表
public class Product {
	private Integer id;
	private Integer categoryId; // 商品类别Id
	private String name; // 商品名称
	private BigDecimal price; // 商品价格
	private Integer num; // 商品库存
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
