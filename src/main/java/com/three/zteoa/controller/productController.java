package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.Mapper.ProductMapper;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

@RestController
public class productController {
	@Resource
	private ProductMapper productMapper;
	
	@RequestMapping("/queryAll")
	//查看所有商品
	public List<Product> queryAll(Product product) {
		return productMapper.getProductList(product);
	}
	
	//添加商品
	@RequestMapping("/Add")
	public int Add(Product product) {
		return productMapper.addProduct(product);
	}
	
	//修改商品
	@RequestMapping("/Modify")
	public int Modify(Product product) {
		return productMapper.modifyProduct(product);
	}
	
	//删除商品
	@RequestMapping("/Delete")
	public int Delete(Integer id) {
		return productMapper.deleteProduct(id);
	}
	
	//统计商品数量
	@RequestMapping("/Count")
	public int Count(Integer num,String name) {
		return productMapper.getCount(num, name);
	}
	
	//查询商品类别id
	@RequestMapping("/pcid")
	public List<ProductCategory> getpcById(Integer id){
		return productMapper.selectpcById(id);
	}
}
