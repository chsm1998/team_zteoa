package com.three.zteoa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

public interface ProductService {
	// 查看所有商品
	public List<Product> getProductList(Product product);

	// 添加商品
	public boolean addProduct(Product product);

	// 修改商品
	public boolean modifyProduct(Product product);

	// 删除商品
	public boolean deleteProduct(Integer id);

	// 统计商品
	public int count(String name);

	// 统计商品数量
	public int getCount(Integer num, String name);

	// 查询商品类别id
	public List<ProductCategory> selectpcById(Integer id);

	/**
	 * 获取商品总数
	 * 
	 * @param product
	 * @return
	 */
	int getTotal(Product product);
}
