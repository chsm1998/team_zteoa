package com.three.zteoa.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;

//��Ʒ��
public interface ProductMapper {

	// �鿴������Ʒ
	public List<Product> getProductList(Product product);

	// �����Ʒ
	public int addProduct(Product product);

	// �޸���Ʒ
	public int modifyProduct(Product product);

	// ɾ����Ʒ
	public int deleteProduct(@Param("id") Integer id);

	// ͳ����Ʒ����
	public int getCount(@Param("num") Integer num, @Param("name") String name);

	// ��ѯ��Ʒ���id
	public List<ProductCategory> selectpcById(@Param("id") Integer id);
}
