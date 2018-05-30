package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

public interface ProductCategoryMapper {

	// 查看商品类别表
	public List<ProductCategory> getProductCategory(@Param("category") String category,@Param ("currentPageNo")int currentPageNo,@Param ("pageSize")int pageSize);

	// 添加商品类别
	public boolean addProductCategory(ProductCategory pc);

	// 修改商品类别
	public boolean modifyProductCategory(ProductCategory pc);

	// 删除商品类别
	public boolean deleteProductCategory(@Param("id") Integer id);

	// 查询商品
	public List<Product> getProductById(@Param("id") Integer id);

	// 统计商品类别数量
	public int getCount(@Param("category") String category);
}
