package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.service.ProductService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductService productService;
	

	@RequestMapping("/queryList")
	// 分页查看商品
	public List<Product> queryList(@RequestBody(required = false) Product product) throws Exception {
		if (product == null) {
			product = new Product();
		} else {
			if (product.getName() != null) {
				product.setName("%" + product.getName() + "%");
			}
		}
		return productService.getProductList(product);
	}

	@RequestMapping("/add")
	// 添加商品
	public boolean Add(@RequestBody Product product) throws Exception {
		return productService.addProduct(product);
	}

	@RequestMapping("/update")
	// 修改商品
	public boolean Modify(@RequestBody Product product) throws Exception {
		return productService.modifyProduct(product);
	}

	@RequestMapping("/delete")
	// 删除商品
	public boolean Delete(Integer id) throws Exception {
		return productService.deleteProduct(id);
	}

	@RequestMapping("/Count")
	// 统计商品数量
	public int Count(Integer num, String name) throws Exception {
		return productService.getCount(num, name);
	}

	@RequestMapping("/NameCount")
	// 统计商品
	public int NameCount(String name) throws Exception {
		return productService.count(name);
	}

	@RequestMapping("/pcid")
	// 查询商品类别id
	public List<ProductCategory> getpcById(Integer id) throws Exception {
		return productService.selectpcById(id);
	}

	/**
	 * 获取商品总数
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping("/queryTotal")
	public int getTotal(@RequestBody Product product) {
		if (product != null && product.getName() != null) {
			product.setName("%" + product.getName() + "%");
		}
		return productService.getTotal(product);
	}
	
	@RequestMapping("/queryAll")
	public List<Product> queryAll() {
		return productService.queryAll();
	}
}
