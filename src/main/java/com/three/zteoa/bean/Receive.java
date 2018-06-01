package com.three.zteoa.bean;

import java.util.Date;

/**
 * @author Vintonsen_lcx
 * @date 2018年5月29日
 * @time 上午8:44:22
 * @description :办公用品申请
 * 
 */
public class Receive {

	private Integer id;// 主键id
	private Integer eid;// 申请人id
	private Integer pid;// 商品id
	private Integer num;// 申请数量
	private String category;// 申请类别
	private String reason;// 申请原因
	private Integer agree;
	private Integer bid;
	private Date createTime;// 申请时间
	private Date modifyTime;// 修改时间
	private Emp emp;
	private Product product;

	private Integer currPage;
	private Integer pageSize;

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

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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

	public Integer getAgree() {
		return agree;
	}

	public void setAgree(Integer agree) {
		this.agree = agree;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Receive [id=" + id + ", eid=" + eid + ", pid=" + pid + ", num=" + num + ", category=" + category
				+ ", reason=" + reason + ", agree=" + agree + ", bid=" + bid + ", createTime=" + createTime
				+ ", modifyTime=" + modifyTime + ", emp=" + emp + ", product=" + product + ", currPage=" + currPage
				+ ", pageSize=" + pageSize + "]";
	}

}
