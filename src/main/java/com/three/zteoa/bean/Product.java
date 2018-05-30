package com.three.zteoa.bean;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//商品表
public class Product {
	private Integer id;
	private Integer category_id; //商品类别Id
	private String name; //商品名称
	private BigDecimal price; //商品价格
	private Integer num; //商品库存
	//对日期格式的设置
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_time; // 创建时间
	//对日期格式的设置
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modify_time; // 修改时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
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
