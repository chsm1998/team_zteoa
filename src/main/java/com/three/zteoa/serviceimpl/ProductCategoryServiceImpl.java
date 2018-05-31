package com.three.zteoa.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductCategoryMapper;
import com.three.zteoa.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Resource
	private ProductCategoryMapper productCategoryMapper;

	// 查看商品类别表
	public List<ProductCategory> getProductCategory(String category, int currentPageNo, int pageSize) throws Exception {
		List<ProductCategory> p_categorylist = null;
		currentPageNo = (currentPageNo - 1) * pageSize;
		p_categorylist = productCategoryMapper.getProductCategory(category, currentPageNo, pageSize);
		return p_categorylist;
	}

	// 添加商品类别
	public boolean AddProductCategory(ProductCategory pc) throws Exception {
		boolean flag = false;
		flag = productCategoryMapper.addProductCategory(pc);
		return flag;
	}

	// 修改商品类别
	public boolean ModifyProductCategory(ProductCategory pc, Integer id) throws Exception {
		boolean flag = false;
		List<Product> productlist = productCategoryMapper.getProductById(id);
		if (productlist.size() > 0) {
			System.out.println("存在外键关联商品无法修改");
		} else {
			flag = productCategoryMapper.modifyProductCategory(pc);
		}
		return flag;
	}

	// 删除商品类别
	public boolean DeleteProductCategory(Integer id) throws Exception {
		boolean flag = false;
		List<Product> productlist = productCategoryMapper.getProductById(id);
		if (productlist.size() > 0) {
			System.out.println("存在外键关联商品无法删除");
		} else {
			flag = productCategoryMapper.deleteProductCategory(id);
		}
		return flag;
	}

	// 查询商品
	public List<Product> getProductById(Integer id) throws Exception {
		List<Product> productlist = null;
		productlist = productCategoryMapper.getProductById(id);
		return productlist;
	}

	// 统计商品类别数量
	public int getcount(String category) throws Exception {
		int result = 0;
		result = productCategoryMapper.getCount(category);
		return result;
	}

	public List<ProductCategory> queryAll() {
		return productCategoryMapper.queryAll();
	}
}
