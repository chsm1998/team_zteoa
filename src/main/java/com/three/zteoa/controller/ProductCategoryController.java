package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.service.ProductCategoryService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
	@Resource
	private ProductCategoryService productCategoryService;

	@RequestMapping("/queryList")
	// 查看商品类别表
	public List<ProductCategory> getpCategory(@RequestBody ProductCategory productCategory) throws Exception {
		return productCategoryService.getProductCategory(productCategory);
	}

	@RequestMapping("/add")
	// 添加商品类别
	public boolean Add(@RequestBody ProductCategory pc) throws Exception {
		return productCategoryService.AddProductCategory(pc);
	}

	@RequestMapping("/update")
	// 修改商品类别
	public boolean Modify(@RequestBody ProductCategory pc) throws Exception {
		return productCategoryService.ModifyProductCategory(pc);
	}

	@RequestMapping("/delete")
	// 删除商品类别
	public UpdateVo Delete(Integer id) throws Exception {
		return productCategoryService.DeleteProductCategory(id);
	}

	@RequestMapping("/queryById")
	// 查询商品
	public List<Product> getProductById(Integer id) throws Exception {
		return productCategoryService.getProductById(id);
	}

	@RequestMapping("/count")
	// 统计商品类别数量
	public int Count(String category) throws Exception {
		return productCategoryService.getcount(category);
	}

	@RequestMapping("/queryAll")
	public List<ProductCategory> queryAll() {
		return productCategoryService.queryAll();
	}
	
	/**
	 * 鉴权
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping("/isAuthority")
	public UpdateVo isAuthority(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return SecurityComponent.isAuthorityProduct(emp);
	}
	
	@RequestMapping("/queryTotal")
	public int queryTotal(@RequestBody(required = false) ProductCategory productCategory) {
		return productCategoryService.queryTotal(productCategory);
	}
}
