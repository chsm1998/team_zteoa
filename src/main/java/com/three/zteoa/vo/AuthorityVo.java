package com.three.zteoa.vo;

import java.util.Arrays;
import java.util.List;

public class AuthorityVo {

	private Integer id;
	private String label;
	private List<AuthorityVo> children;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public List<AuthorityVo> getChildren() {
		return children;
	}

	public void setChildren(List<AuthorityVo> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "AuthorityVo [id=" + id + ", label=" + label + ", children=" + children + "]";
	}

}
