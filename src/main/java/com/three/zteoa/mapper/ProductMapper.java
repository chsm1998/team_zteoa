package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

public interface ProductMapper {

	// 查看所有商品
	public List<Product> getProductList(@Param("name") String name,@Param ("currentPageNo")int currentPageNo,@Param ("pageSize")int pageSize);

	// 添加商品
	public boolean addProduct(Product product);

	// 修改商品
	public boolean modifyProduct(Product product);

	// 删除商品
	public boolean deleteProduct(@Param("id") Integer id);
	
	//统计商品
	public int count(@Param("name") String name);
	
	// 统计商品数量
	public int getCount(@Param("num") Integer num, @Param("name") String name);

	// 查询商品类别id
	public List<ProductCategory> selectpcById(@Param("id") Integer id);
}
