package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.ProductCategoryService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {
	@Resource
	private ProductCategoryService productCategoryService;
	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/queryList")
	// 查看商品类别表
	public List<ProductCategory> getpCategory(@RequestBody ProductCategory productCategory) throws Exception {
		return productCategoryService.getProductCategory(productCategory);
	}

	@RequestMapping("/add")
	// 添加商品类别
	public UpdateVo Add(@RequestBody ProductCategory pc, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.PRODUCT_TYPE_MANAGER, TypeEnum.ADD);
		if (updateVo.isBl()) {
			if (productCategoryService.AddProductCategory(pc)) {
				return new UpdateVo("添加商品类别成功", true);
			}
			return new UpdateVo("添加商品类别失败，服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/update")
	// 修改商品类别
	public UpdateVo Modify(@RequestBody ProductCategory pc, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.PRODUCT_TYPE_MANAGER, TypeEnum.UDPATE);
		if (updateVo.isBl()) {
			if (productCategoryService.ModifyProductCategory(pc)) {
				return new UpdateVo("更新商品类别成功", true);
			}
			return new UpdateVo("更新商品类别失败，服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/delete")
	// 删除商品类别
	public UpdateVo Delete(Integer id, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.PRODUCT_TYPE_MANAGER, TypeEnum.ADD);
		if (updateVo.isBl()) {
			return productCategoryService.DeleteProductCategory(id);
		}
		return updateVo;
	}

	@RequestMapping("/queryById")
	// 查询商品
	public List<Product> getProductById(Integer id) throws Exception {
		return productCategoryService.getProductById(id);
	}

	@RequestMapping("/count")
	// 统计商品类别数量
	public int Count(String category) throws Exception {
		return productCategoryService.getcount(category);
	}

	@RequestMapping("/queryAll")
	public List<ProductCategory> queryAll() {
		return productCategoryService.queryAll();
	}

	@RequestMapping("/queryTotal")
	public int queryTotal(@RequestBody(required = false) ProductCategory productCategory) {
		return productCategoryService.queryTotal(productCategory);
	}

	@RequestMapping("/getAuthoritys")
	public List<Authority> getAuthoritys(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return authorityService.queryByEmpAndModule(emp, ModuleEnum.PRODUCT_TYPE_MANAGER);
	}
}
