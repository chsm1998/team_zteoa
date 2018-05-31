package com.three.zteoa.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//商品类别表
public class ProductCategory {
	private Integer id;
	private String category; // 商品类别名称
	private Date createTime; // 创建时间
	private Date modifyTime; // 修改时间
	private Integer currPage;
	private Integer pageSize;

	public Integer getCurrPage() {
		return currPage;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", category=" + category + ", createTime=" + createTime + ", modifyTime="
				+ modifyTime + ", currPage=" + currPage + ", pageSize=" + pageSize + "]";
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
