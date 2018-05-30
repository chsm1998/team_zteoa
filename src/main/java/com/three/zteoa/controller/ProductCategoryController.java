package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.service.ProductCategoryService;

@RestController
public class ProductCategoryController {
	@Resource
	private ProductCategoryService productCategoryService;

	@RequestMapping("/queryAll")
	// 查看商品类别表
	public List<ProductCategory> getpCategory(ProductCategory pc) throws Exception {
		return productCategoryService.getProductCategory(pc);
	}

	@RequestMapping("/add")
	// 添加商品类别
	public boolean Add(ProductCategory pc) throws Exception {
		return productCategoryService.AddProductCategory(pc);
	}

	@RequestMapping("/modify")
	// 修改商品类别
	public boolean Modify(ProductCategory pc, Integer id) throws Exception {
		return productCategoryService.ModifyProductCategory(pc, id);
	}

	@RequestMapping("/delete")
	// 删除商品类别
	public boolean Delete(Integer id) throws Exception {
		return productCategoryService.DeleteProductCategory(id);
	}

	@RequestMapping("/queryAll")
	// 查询商品
	public List<Product> getProductById(Integer id) throws Exception {
		return productCategoryService.getProductById(id);
	}

	@RequestMapping("/count")
	// 统计商品类别数量
	public int Count(Integer id) throws Exception {
		return productCategoryService.getcount(id);
	}
}
