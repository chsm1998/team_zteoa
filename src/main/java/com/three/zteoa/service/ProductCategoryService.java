package com.three.zteoa.service;

import java.util.List;


import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.vo.UpdateVo;

public interface ProductCategoryService {

	// 查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory productCategory);

	// 添加商品类别
	public boolean AddProductCategory(ProductCategory pc);

	// 修改商品类别
	public boolean ModifyProductCategory(ProductCategory pc);

	// 删除商品类别
	public UpdateVo DeleteProductCategory(Integer id);

	// 查询商品
	public List<Product> getProductById(Integer id);

	// 统计商品类别数量
	public int getcount(String category);
	
	List<ProductCategory> queryAll();
	
	int queryTotal (ProductCategory productCategory);

}
