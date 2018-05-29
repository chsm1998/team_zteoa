package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductCategoryMapper;

@RestController
public class ProductCategoryController {
	@Resource
	private ProductCategoryMapper productCategoryMapper;

	// ��ѯ��Ʒ���
	@RequestMapping("/queryAll")
	public List<ProductCategory> getpCategory(ProductCategory pc) {
		System.out.println("test");
		return productCategoryMapper.getProductCategory(pc);
	}

	// �����Ʒ���
	@RequestMapping("/add")
	public int Add(ProductCategory pc) {
		return productCategoryMapper.addProductCategory(pc);
	}

	// �޸���Ʒ���
	@RequestMapping("/modify")
	public int Modify(ProductCategory pc) {
		return productCategoryMapper.modifyProductCategory(pc);
	}

	// ɾ����Ʒ���
	@RequestMapping("/delete")
	public int Delete(Integer id) {
		return productCategoryMapper.deleteProductCategory(id);
	}

	// ��ѯ��Ʒ
	@RequestMapping("/queryAll")
	public List<Product> getProductById(Integer id) {
		return productCategoryMapper.getProductById(id);
	}

	// ͳ����Ʒ�������
	@RequestMapping("/count")
	public int Count(Integer id) {
		return productCategoryMapper.getCount(id);
	}
}
