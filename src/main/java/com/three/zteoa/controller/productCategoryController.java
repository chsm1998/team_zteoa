package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.Mapper.ProductCategoryMapper;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;


@RestController
public class productCategoryController {
	@Resource
	private ProductCategoryMapper productCategoryMapper;
	
	//查询商品类别
	@RequestMapping("/queryAll")
	public List<ProductCategory> getpCategory(ProductCategory pc) {
		return productCategoryMapper.getProductCategory(pc);
	}
	
	//添加商品类别
	@RequestMapping("/Add")
	public int Add(ProductCategory pc) {
		return productCategoryMapper.addProductCategory(pc);
	}
	
	//修改商品类别
	@RequestMapping("/Modify")
	public int Modify(ProductCategory pc) {
		return productCategoryMapper.modifyProductCategory(pc);
	}
	
	//删除商品类别
	@RequestMapping("/Delete")
	public int Delete(Integer id) {
		return productCategoryMapper.deleteProductCategory(id);
	}
	//查询商品
	@RequestMapping("/queryAll")
	public List<Product> getProductById(Integer id){
		return productCategoryMapper.getProductById(id);
	}
	
	//统计商品类别数量
	@RequestMapping("/Count")
	public int Count(Integer id){
		return productCategoryMapper.getCount(id);
	}
}
