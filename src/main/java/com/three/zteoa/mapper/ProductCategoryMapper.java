package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

public interface ProductCategoryMapper {

	// 查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory productCategory);

	// 添加商品类别
	public int addProductCategory(ProductCategory pc);

	// 修改商品类别
	public int modifyProductCategory(ProductCategory pc);

	// 删除商品类别
	public int deleteProductCategory(@Param("id") Integer id);

	// 查询商品
	public List<Product> getProductById(@Param("id") Integer id);

	// 统计商品类别数量
	public int getCount(@Param("category") String category);
	
	/**
	 * 查询所有商品类别
	 * @return
	 */
	List<ProductCategory> queryAll();
	
	/**
	 * 判断当前类别是否存在
	 * @param category
	 * @return
	 */
	int queryByName(String category);
	
	/**
	 * 获取总记录数
	 * @param category
	 * @return
	 */
	int getTotal(ProductCategory productCategory);
}
