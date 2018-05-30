package com.three.zteoa.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductCategoryMapper;
import com.three.zteoa.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Resource
	private ProductCategoryMapper productCategoryMapper;

	// 查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory pc) throws Exception {
		List<ProductCategory> p_categorylist = null;
		try {
			p_categorylist = productCategoryMapper.getProductCategory(pc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p_categorylist;
	}

	// 添加商品类别
	public boolean AddProductCategory(ProductCategory pc) throws Exception {
		boolean flag = false;
		try {
			flag = productCategoryMapper.addProductCategory(pc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 修改商品类别
	public boolean ModifyProductCategory(ProductCategory pc, Integer id) throws Exception {
		boolean flag = false;
		try {
			List<Product> productlist = productCategoryMapper.getProductById(id);
			if (productlist.size() > 0) {
				System.out.println("存在外键关联商品无法修改");
			} else {
				flag = productCategoryMapper.modifyProductCategory(pc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 删除商品类别
	public boolean DeleteProductCategory(Integer id) throws Exception {
		boolean flag = false;
		try {
			List<Product> productlist = productCategoryMapper.getProductById(id);
			if (productlist.size() > 0) {
				System.out.println("存在外键关联商品无法删除");
			} else {
				flag = productCategoryMapper.deleteProductCategory(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 查询商品
	public List<Product> getProductById(Integer id) throws Exception {
		List<Product> productlist = null;
		try {
			productlist = productCategoryMapper.getProductById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}

	// 统计商品类别数量
	public int getcount(Integer id) throws Exception {
		int result = 0;
		try {
			result = productCategoryMapper.getCount(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
