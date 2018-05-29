package com.three.zteoa.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

//��Ʒ����
public interface ProductCategoryService {

	// �鿴��Ʒ����
	public List<ProductCategory> getProductCategory(ProductCategory pc) throws Exception;

	// �����Ʒ���
	public int AddProductCategory(ProductCategory pc) throws Exception;

	// �޸���Ʒ���
	public int ModifyProductCategory(ProductCategory pc, Integer id) throws Exception;

	// ɾ����Ʒ���
	public int DeleteProductCategory(Integer id) throws Exception;

	// ��ѯ��Ʒ
	public List<Product> getProductById(Integer id) throws Exception;

	// ͳ����Ʒ�������
	public int getcount(Integer id);

}
