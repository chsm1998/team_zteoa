package com.three.zteoa.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

//��Ʒ����
public class ProductCategory {
	private Integer id;		
	private String category;	//��Ʒ�������
	//�����ڸ�ʽ������
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date create_time;   //����ʱ��
	//�����ڸ�ʽ������
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date modify_time;	//�޸�ʱ��
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
