package com.three.zteoa.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

//商品类别表
public interface ProductCategoryMapper {
	
	//查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory pc);
	
	//添加商品类别
	public int addProductCategory (ProductCategory pc);
	
	//修改商品类别
	public int modifyProductCategory(ProductCategory pc);
	
	//删除商品类别
	public int  deleteProductCategory(@Param("id")Integer id);
	
	//查询商品
	public List<Product> getProductById(@Param("id")Integer id);
	
	//统计商品类别数量
	public int  getCount(@Param("id")Integer id);
}
