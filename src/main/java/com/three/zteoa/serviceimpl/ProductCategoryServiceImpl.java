package com.three.zteoa.serviceimpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductCategoryMapper;
import com.three.zteoa.service.ProductCategoryService;
import com.three.zteoa.vo.UpdateVo;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Resource
	private ProductCategoryMapper productCategoryMapper;

	// 查看商品类别表
	public List<ProductCategory> getProductCategory(ProductCategory productCategory) {
		productCategory.setCurrPage((productCategory.getCurrPage() - 1) * productCategory.getPageSize());
		if (productCategory.getCategory() != null) {
			productCategory.setCategory("%" + productCategory.getCategory() + "%");
		}
		return productCategoryMapper.getProductCategory(productCategory);
	}

	// 添加商品类别
	public boolean AddProductCategory(ProductCategory pc) {
		Date date = new Date();
		pc.setCreateTime(date);
		pc.setModifyTime(date);
		return productCategoryMapper.addProductCategory(pc) == 1;
	}

	// 修改商品类别
	public boolean ModifyProductCategory(ProductCategory pc) {
		pc.setModifyTime(new Date());
		return productCategoryMapper.modifyProductCategory(pc) == 1;
	}

	// 删除商品类别
	public UpdateVo DeleteProductCategory(Integer id) {
		if (productCategoryMapper.getProductById(id).size() > 0) {
			return new UpdateVo("该类别下存在用品，禁止删除！！！", false);
		}
		if (productCategoryMapper.deleteProductCategory(id) == 1) {
			return new UpdateVo("删除成功", true);
		}
		return new UpdateVo("删除失败，服务器异常", false);
	}

	// 查询商品
	public List<Product> getProductById(Integer id) {
		List<Product> productlist = null;
		productlist = productCategoryMapper.getProductById(id);
		return productlist;
	}

	// 统计商品类别数量
	public int getcount(String category) {
		int result = 0;
		result = productCategoryMapper.getCount(category);
		return result;
	}

	public List<ProductCategory> queryAll() {
		return productCategoryMapper.queryAll();
	}

	@Override
	public int queryTotal(ProductCategory productCategory) {
		if (productCategory == null) {
			productCategory = new ProductCategory();
		}
		return productCategoryMapper.getTotal(productCategory);
	}
}
