package com.three.zetoa.test;



import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.Product;
import com.three.zteoa.service.ProductService;
@Rollback(false)
public class ProductTest extends BaseTest{
	
	@Autowired
	private ProductService productService;
	
	@Test
	public void queryAll() {
		try {
			productService.getProductList(null,2,5).forEach(System.out::println);;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryAdd() {
		try {
			Product product =new Product(); 
			product.setId(50);
			product.setCategoryId(2);
			product.setName("剪刀");
			product.setNum(10000);
			product.setPrice(new BigDecimal(13.00));
			product.setCreateTime(new Date());
			productService.addProduct(product, 2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryModify() {
		try {
			Product product =new Product(); 
			product.setId(50);
			product.setName("刀片");
			product.setNum(10000);
			product.setPrice(new BigDecimal(13.00));
			product.setModifyTime(new Date());
			productService.modifyProduct(product);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryDelete() {
		try {
			productService.deleteProduct(50);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//统计商品数量得到库存数
	public void getCount() {
		try {
			Product product =new Product(); 
			product.getNum();
			productService.getCount(product.getNum(),"U盘");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//统计商品
	public void Count() {
		try {
			Product p=new Product();
			productService.count("U盘");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//查询商品类别关联到商品添加
	public void selectpCategory() {
		try {
			productService.selectpcById(3);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
