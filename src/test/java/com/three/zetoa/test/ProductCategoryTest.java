package com.three.zetoa.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.service.ProductCategoryService;

@Rollback(false)
public class ProductCategoryTest extends BaseTest{
	@Autowired
	public ProductCategoryService productCategoryService;
	
	@Test
	public  void queryAll() {
		try {
			productCategoryService.getProductCategory("桌面用品",2,5).forEach(System.out::println);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryAdd() {
		try {
			ProductCategory pc=new ProductCategory();
			pc.setCategory("纪念日百货");
			pc.setId(20);
			pc.setCreateTime(new Date());
			productCategoryService.AddProductCategory(pc);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryModify() {
		try {
			ProductCategory pc=new ProductCategory();
			pc.setCategory("纪念日百货1");
			pc.setId(20);
			pc.setModifyTime(new Date());
			productCategoryService.AddProductCategory(pc);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryDelete() {
		try {
			productCategoryService.DeleteProductCategory(20);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void queryCount() {
		try {
			productCategoryService.getcount("桌面用品");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//查询商品关联到删除和修改
	public void selectProduct() {
		try {
			productCategoryService.getProductById(2);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
