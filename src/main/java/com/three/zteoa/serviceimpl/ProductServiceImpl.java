package com.three.zteoa.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductMapper;
import com.three.zteoa.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper productMapper;

	// 查看所有商品
	public List<Product> getProductList(Product product) {
		List<Product> productlist = null;
		product.setCurrPage((product.getCurrPage() - 1) * product.getPageSize());
		;
		productlist = productMapper.getProductList(product);
		return productlist;
	}

	// 添加商品
	public boolean addProduct(Product product) {
		return productMapper.addProduct(product);
	}

	// 修改商品
	public boolean modifyProduct(Product product) {
		return productMapper.modifyProduct(product);
	}

	// 删除商品
	public boolean deleteProduct(Integer id) {
		return productMapper.deleteProduct(id);
	}

	// 统计商品数量
	public int getCount(Integer num, String name) {
		int result = 0;
		Product product = new Product();
		if (product.getNum() > 200) {
			result = productMapper.getCount(product.getNum(), name);
		} else {
			System.out.println(name + "库存数量不足请及时补充！");
		}
		return result;
	}

	// 查询商品类别id
	public List<ProductCategory> selectpcById(Integer id) {
		List<ProductCategory> pclist = null;
		pclist = productMapper.selectpcById(id);
		return pclist;
	}

	// 统计商品
	public int count(String name) {
		int result = 0;
		result = productMapper.count(name);
		return result;
	}

	@Override
	public int getTotal(Product product) {
		return productMapper.getTotal(product);
	}

	@Override
	public List<Product> queryAll() {
		return productMapper.queryAll();
	}

}
