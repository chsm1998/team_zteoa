package com.three.zteoa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

//��Ʒ��
public interface ProductService {
	// �鿴������Ʒ
	public List<Product> getProductList(Product product) throws Exception;

	// �����Ʒ
	public int addProduct(Product product, Integer id) throws Exception;

	// �޸���Ʒ
	public int modifyProduct(Product product) throws Exception;

	// ɾ����Ʒ
	public int deleteProduct(Integer id) throws Exception;

	// ͳ����Ʒ����
	public int getCount(Integer num, String name) throws Exception;

	// ��ѯ��Ʒ���id
	public List<ProductCategory> selectpcById(Integer id) throws Exception;
}
