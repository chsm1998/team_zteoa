package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

//��Ʒ����
public interface ProductCategoryMapper {

	// �鿴��Ʒ����
	public List<ProductCategory> getProductCategory(ProductCategory pc);

	// �����Ʒ���
	public int addProductCategory(ProductCategory pc);

	// �޸���Ʒ���
	public int modifyProductCategory(ProductCategory pc);

	// ɾ����Ʒ���
	public int deleteProductCategory(@Param("id") Integer id);

	// ��ѯ��Ʒ
	public List<Product> getProductById(@Param("id") Integer id);

	// ͳ����Ʒ�������
	public int getCount(@Param("id") Integer id);
}
