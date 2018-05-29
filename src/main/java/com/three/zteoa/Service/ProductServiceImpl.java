package com.three.zteoa.Service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.Mapper.ProductMapper;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
@Service
public class ProductServiceImpl implements ProductService {
@Resource 
 private ProductMapper productMapper;
	//查看所有商品
	public List<Product> getProductList(Product product) throws Exception {
		List<Product> productlist=null;
		try {
			productlist=productMapper.getProductList(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}
	
	//添加商品
	public int addProduct(Product product,Integer id) throws Exception {
		int result=0;
		List<ProductCategory> pclist=null;
		try {
			pclist=productMapper.selectpcById(id);
			if(pclist.size()>0) {
				result=productMapper.addProduct(product);
			}else {
				System.out.println("没有商品类别Id无法添加");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//修改商品
	public int modifyProduct(Product product) throws Exception {
		int result=0;
		try {
			result=productMapper.modifyProduct(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//删除商品
	public int deleteProduct(Integer id) throws Exception {
		int result=0;
		try {
			result=productMapper.deleteProduct(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	//统计商品数量
	public int getCount(Integer num, String name) throws Exception {
		int result=0;
		try {
			if(num>200) {
				result=productMapper.getCount(num, name);
			}else {
				System.out.println(name+"商品库存不足");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//查询商品类别id
	public List<ProductCategory> selectpcById(Integer id) {
		List<ProductCategory> pclist=null;
		try {
			pclist=productMapper.selectpcById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return pclist;
	}
	
}
