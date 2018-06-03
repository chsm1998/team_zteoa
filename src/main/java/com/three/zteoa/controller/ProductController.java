package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Authority;
import com.three.zteoa.bean.Emp;
import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.component.SecurityComponent;
import com.three.zteoa.myenum.ModuleEnum;
import com.three.zteoa.myenum.TypeEnum;
import com.three.zteoa.service.AuthorityService;
import com.three.zteoa.service.ProductService;
import com.three.zteoa.vo.UpdateVo;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Resource
	private ProductService productService;
	@Autowired
	private SecurityComponent securityComponent;
	@Autowired
	private AuthorityService authorityService;

	@RequestMapping("/queryList")
	// 分页查看商品
	public List<Product> queryList(@RequestBody(required = false) Product product) throws Exception {
		if (product == null) {
			product = new Product();
		} else {
			if (product.getName() != null) {
				product.setName("%" + product.getName() + "%");
			}
		}
		return productService.getProductList(product);
	}

	@RequestMapping("/add")
	// 添加商品
	public UpdateVo Add(@RequestBody Product product,HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		if (product.getId() != null) {
			return Modify(product, session);
		}
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.PRODUCT_MANAGER, TypeEnum.ADD);
		if (updateVo.isBl()) {
			if (productService.addProduct(product)) {
				return new UpdateVo("添加商品成功", true);
			}
			return new UpdateVo("添加商品失败，服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/update")
	// 修改商品
	public UpdateVo Modify(@RequestBody Product product, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.PRODUCT_MANAGER, TypeEnum.ADD);
		if (updateVo.isBl()) {
			if (productService.modifyProduct(product)) {
				return new UpdateVo("更新商品成功", true);
			}
			return new UpdateVo("更新商品失败，服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/delete")
	// 删除商品
	public UpdateVo Delete(Integer id, HttpSession session) throws Exception {
		Emp emp = (Emp) session.getAttribute("empSession");
		UpdateVo updateVo = securityComponent.isAuthorityUpdate(emp, ModuleEnum.PRODUCT_MANAGER, TypeEnum.DELETE);
		if (updateVo.isBl()) {
			if (productService.deleteProduct(id)) {
				return new UpdateVo("删除商品成功", true);
			}
			return new UpdateVo("删除商品失败，服务器异常", false);
		}
		return updateVo;
	}

	@RequestMapping("/Count")
	// 统计商品数量
	public int Count(Integer num, String name) throws Exception {
		return productService.getCount(num, name);
	}

	@RequestMapping("/NameCount")
	// 统计商品
	public int NameCount(String name) throws Exception {
		return productService.count(name);
	}

	@RequestMapping("/pcid")
	// 查询商品类别id
	public List<ProductCategory> getpcById(Integer id) throws Exception {
		return productService.selectpcById(id);
	}

	/**
	 * 获取商品总数
	 * 
	 * @param product
	 * @return
	 */
	@RequestMapping("/queryTotal")
	public int getTotal(@RequestBody Product product) {
		if (product != null && product.getName() != null) {
			product.setName("%" + product.getName() + "%");
		}
		return productService.getTotal(product);
	}

	@RequestMapping("/queryAll")
	public List<Product> queryAll() {
		return productService.queryAll();
	}
	
	@RequestMapping("/getAuthoritys")
	public List<Authority> getAuthoritys(HttpSession session) {
		Emp emp = (Emp) session.getAttribute("empSession");
		return authorityService.queryByEmpAndModule(emp, ModuleEnum.PRODUCT_MANAGER);
	}
	
	@RequestMapping("/isMaxNum")
	public boolean isMaxNum(@RequestBody Product product) {
		if (productService.queryById(product.getId()).getNum() >= product.getNum()) {
			return true;
		}
		return false;
	}
}
