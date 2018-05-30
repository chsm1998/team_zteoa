package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.service.ProductService;
import com.three.zteoa.tools.PageSupport;

@RestController
public class ProductController {
	@Resource
	private ProductService productService;

	@RequestMapping("/queryAll")
	// 查看所有商品
	public List<Product> queryAll(Model model,
			 @RequestParam(value="name",required=false) String name,
			 @RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception {
		 
		//设置页面容量
		 int pageSize=5;
		 //设置当前页码
		 int currentPageNo=1;
	
		 if(name ==null) {
			 name="";
		 }
		 if(pageIndex !=null) {
			 try {
			 currentPageNo =Integer.parseInt(pageIndex);
			 }catch(NumberFormatException b) {
				 b.printStackTrace();
			 }
		 }
		 //总数量
		 int totalCount =productService.count(name);
		 PageSupport pages =new PageSupport();
		 pages.setCurrentPageNo(currentPageNo);
		 pages.setPageSize(pageSize);
		 pages.setTotalCount(totalCount);
		 
		 //得到总页数
		 int totalPageCount =pages.getTotalPageCount();
		 //控住首页和尾页
		 if(currentPageNo<1) {
			 currentPageNo=1;
		 }else if(currentPageNo>totalPageCount) {
			 currentPageNo = totalPageCount;
		 }
		 model.addAttribute("name",name);
		 model.addAttribute("totalPageCount", totalPageCount);
		 model.addAttribute("totalCount", totalCount);
		 model.addAttribute("currentPageNo", currentPageNo);
		return productService.getProductList(name, currentPageNo, pageSize);
	}

	@RequestMapping("/Add")
	// 添加商品
	public boolean Add(Product product, Integer id) throws Exception {
		return productService.addProduct(product, id);
	}

	@RequestMapping("/Modify")
	// 修改商品
	public boolean Modify(Product product) throws Exception {
		return productService.modifyProduct(product);
	}

	@RequestMapping("/Delete")
	// 删除商品
	public boolean Delete(Integer id) throws Exception {
		return productService.deleteProduct(id);
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
}
