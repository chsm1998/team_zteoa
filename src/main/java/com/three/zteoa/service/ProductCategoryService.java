package com.three.zteoa.service;

import java.util.List;


import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;


public interface ProductCategoryService {

	//查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory pc) throws Exception;

	//添加商品类别
	public boolean AddProductCategory(ProductCategory pc) throws Exception;

	//修改商品类别
	public boolean ModifyProductCategory(ProductCategory pc, Integer id) throws Exception;

	//删除商品类别
	public boolean DeleteProductCategory(Integer id) throws Exception;

	//查询商品
	public List<Product> getProductById(Integer id) throws Exception;

	//统计商品类别数量
	public int getcount(Integer id)throws Exception;

}
