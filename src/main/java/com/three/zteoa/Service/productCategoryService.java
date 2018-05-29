package com.three.zteoa.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
//商品类别表
public interface productCategoryService {
	
	//查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory pc)throws Exception;
		
	//添加商品类别
	public int AddProductCategory (ProductCategory pc)throws Exception;
		
	//修改商品类别
	public int ModifyProductCategory(ProductCategory pc,Integer id)throws Exception;
		
	//删除商品类别
	public int  DeleteProductCategory(Integer id)throws Exception;
	
	//查询商品
	public List<Product> getProductById(Integer id)throws Exception;
	
	//统计商品类别数量
	public int  getcount(Integer id);

}
