package com.three.zteoa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.mapper.ProductCategoryMapper;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	@Resource
	private ProductCategoryMapper productCategoryMapper;

	// �鿴��Ʒ����
	public List<ProductCategory> getProductCategory(ProductCategory pc) throws Exception {
		List<ProductCategory> p_categorylist = null;
		try {
			p_categorylist = productCategoryMapper.getProductCategory(pc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p_categorylist;
	}

	// �����Ʒ���
	public int AddProductCategory(ProductCategory pc) throws Exception {
		int result = 0;
		try {
			result = productCategoryMapper.addProductCategory(pc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// �޸���Ʒ���
	public int ModifyProductCategory(ProductCategory pc, Integer id) throws Exception {
		int result = 0;
		try {
			List<Product> productlist = productCategoryMapper.getProductById(id);
			if (productlist.size() > 0) {
				System.out.println("�޷��޸�");
			} else {
				result = productCategoryMapper.modifyProductCategory(pc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ɾ����Ʒ���
	public int DeleteProductCategory(Integer id) throws Exception {
		int result = 0;
		try {
			List<Product> productlist = productCategoryMapper.getProductById(id);
			if (productlist.size() > 0) {
				System.out.println("�޷�ɾ��");
			} else {
				result = productCategoryMapper.deleteProductCategory(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// ��ѯ��Ʒ
	public List<Product> getProductById(Integer id) throws Exception {
		List<Product> productlist = null;
		try {
			productlist = productCategoryMapper.getProductById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productlist;
	}

	// ͳ����Ʒ�������
	public int getcount(Integer id) {
		int result = 0;
		try {
			result = productCategoryMapper.getCount(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
