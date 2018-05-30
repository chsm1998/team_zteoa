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
	public List<Product> getProductList(Product product) throws Exception {
		List<Product> productlist = null;
		try {
			productlist = productMapper.getProductList(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}

	// 添加商品
	public boolean addProduct(Product product, Integer id) throws Exception {
		boolean flag = false;
		List<ProductCategory> pclist = null;
		try {
			pclist = productMapper.selectpcById(id);
			if (pclist.size() > 0) {
				flag = productMapper.addProduct(product);
			} else {
				System.out.println("商品类别id不存在无法添加");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 修改商品
	public boolean modifyProduct(Product product) throws Exception {
		boolean flag = false;
		try {
			flag = productMapper.modifyProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 删除商品
	public boolean deleteProduct(Integer id) throws Exception {
		boolean flag = false;
		try {
			flag = productMapper.deleteProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// 统计商品数量
	public int getCount(Integer num, String name) throws Exception {
		int result = 0;
		try {
			if (num > 200) {
				result = productMapper.getCount(num, name);
			} else {
				System.out.println(name + "库存数量不足请及时补充！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 查询商品类别id
	public List<ProductCategory> selectpcById(Integer id) {
		List<ProductCategory> pclist = null;
		try {
			pclist = productMapper.selectpcById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pclist;
	}

}
