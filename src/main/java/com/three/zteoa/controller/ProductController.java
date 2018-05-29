package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductMapper;

@RestController
public class ProductController {
	@Resource
	private ProductMapper productMapper;

	@RequestMapping("/queryAll")
	// �鿴������Ʒ
	public List<Product> queryAll(Product product) {
		return productMapper.getProductList(product);
	}

	// �����Ʒ
	@RequestMapping("/Add")
	public int Add(Product product) {
		return productMapper.addProduct(product);
	}

	// �޸���Ʒ
	@RequestMapping("/Modify")
	public int Modify(Product product) {
		return productMapper.modifyProduct(product);
	}

	// ɾ����Ʒ
	@RequestMapping("/Delete")
	public int Delete(Integer id) {
		return productMapper.deleteProduct(id);
	}

	// ͳ����Ʒ����
	@RequestMapping("/Count")
	public int Count(Integer num, String name) {
		return productMapper.getCount(num, name);
	}

	// ��ѯ��Ʒ���id
	@RequestMapping("/pcid")
	public List<ProductCategory> getpcById(Integer id) {
		return productMapper.selectpcById(id);
	}
}
