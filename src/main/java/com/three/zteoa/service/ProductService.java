package com.three.zteoa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

public interface ProductService {
	// 查看所有商品
	public List<Product> getProductList( String name,int currentPageNo,int pageSize) throws Exception;

	// 添加商品
	public boolean addProduct(Product product, Integer id) throws Exception;

	// 修改商品
	public boolean modifyProduct(Product product) throws Exception;

	// 删除商品
	public boolean deleteProduct(Integer id) throws Exception;
	
	//统计商品
	public int count(String name)throws Exception;
		
	// 统计商品数量
	public int getCount(Integer num, String name) throws Exception;

	// 查询商品类别id
	public List<ProductCategory> selectpcById(Integer id) throws Exception;
}
