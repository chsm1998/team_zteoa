package com.three.zteoa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductMapper productMapper;

	// �鿴������Ʒ
	public List<Product> getProductList(Product product) throws Exception {
		List<Product> productlist = null;
		try {
			productlist = productMapper.getProductList(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}

	// �����Ʒ
	public int addProduct(Product product, Integer id) throws Exception {
		int result = 0;
		List<ProductCategory> pclist = null;
		try {
			pclist = productMapper.selectpcById(id);
			if (pclist.size() > 0) {
				result = productMapper.addProduct(product);
			} else {
				System.out.println("û����Ʒ���Id�޷����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// �޸���Ʒ
	public int modifyProduct(Product product) throws Exception {
		int result = 0;
		try {
			result = productMapper.modifyProduct(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ɾ����Ʒ
	public int deleteProduct(Integer id) throws Exception {
		int result = 0;
		try {
			result = productMapper.deleteProduct(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ͳ����Ʒ����
	public int getCount(Integer num, String name) throws Exception {
		int result = 0;
		try {
			if (num > 200) {
				result = productMapper.getCount(num, name);
			} else {
				System.out.println(name + "��Ʒ��治��");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯ��Ʒ���id
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
