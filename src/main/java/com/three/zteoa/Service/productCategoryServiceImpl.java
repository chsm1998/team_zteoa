package com.three.zteoa.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.Mapper.ProductCategoryMapper;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;


@Service
public class productCategoryServiceImpl implements productCategoryService{
@Resource
	private ProductCategoryMapper productCategoryMapper;
	
	//查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory pc) throws Exception {
		List<ProductCategory> p_categorylist=null;
		try {
			p_categorylist=productCategoryMapper.getProductCategory(pc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p_categorylist;
	}
	
	//添加商品类别
	public int AddProductCategory(ProductCategory pc) throws Exception {
		int result=0;
		try {
			result=productCategoryMapper.addProductCategory(pc);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//修改商品类别
	public int ModifyProductCategory(ProductCategory pc,Integer id) throws Exception {
		int result=0;
		try {	
			List<Product> productlist=productCategoryMapper.getProductById(id);
			if(productlist.size()>0) {
				System.out.println("无法修改");
			}else{
				result=productCategoryMapper.modifyProductCategory(pc);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//删除商品类别
	public int DeleteProductCategory(Integer id) throws Exception {
		int result=0;
		try {
			List<Product> productlist=productCategoryMapper.getProductById(id);
			if(productlist.size()>0) {
				System.out.println("无法删除");
			}else {
			result=productCategoryMapper.deleteProductCategory(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//查询商品
	public List<Product> getProductById(Integer id) throws Exception {
		List<Product> productlist=null;
		try {
			productlist=productCategoryMapper.getProductById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}

	//统计商品类别数量
	public int getcount(Integer id) {
		int result=0;
		try {
			result=productCategoryMapper.getCount(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
