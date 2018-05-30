package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.service.ProductService;


@RestController
public class ProductController {
	@Resource
	private ProductService productService ;

	@RequestMapping("/queryAll")
	//查看所有商品
	public List<Product> queryAll(Product product) throws Exception {
		return productService.getProductList(product);
	}

	@RequestMapping("/Add")
	//添加商品 
	public boolean Add(Product product,Integer id) throws Exception {
		return productService.addProduct(product, id);
	}

	
	@RequestMapping("/Modify")
	//修改商品 
	public boolean Modify(Product product) throws Exception {
		return productService.modifyProduct(product);
	}

	@RequestMapping("/Delete")
	//删除商品 
	public boolean Delete(Integer id) throws Exception {
		return productService.deleteProduct(id);
	}

	@RequestMapping("/Count")
	//统计商品数量 
	public int Count(Integer num, String name) throws Exception {
		return productService.getCount(num, name);
	}

	@RequestMapping("/pcid")
	// 查询商品类别id
	public List<ProductCategory> getpcById(Integer id) throws Exception {
		return productService.selectpcById(id);
	}
}
