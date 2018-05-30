package com.three.zteoa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.three.zteoa.bean.Product;
import com.three.zteoa.bean.ProductCategory;
import com.three.zteoa.service.ProductCategoryService;
import com.three.zteoa.tools.PageSupport;

@RestController
public class ProductCategoryController {
	@Resource
	private ProductCategoryService productCategoryService;

	@RequestMapping("/queryAll")
	// 查看商品类别表
	public List<ProductCategory> getpCategory(Model model,
			 @RequestParam(value="category",required=false) String category,
			 @RequestParam(value="pageIndex",required=false) String pageIndex) throws Exception {
		//设置页面容量
		 int pageSize=5;
		 //设置当前页码
		 int currentPageNo=1;
		 
		 if(category ==null) {
			 category="";
		 }
		 if(pageIndex !=null) {
			 try {
			 currentPageNo =Integer.parseInt(pageIndex);
			 }catch(NumberFormatException b) {
				 b.printStackTrace();
			 }
		 }
		 //总数量
		 int totalCount =productCategoryService.getcount(category);
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
		 model.addAttribute("category",category);
		 model.addAttribute("totalPageCount", totalPageCount);
		 model.addAttribute("totalCount", totalCount);
		 model.addAttribute("currentPageNo", currentPageNo);
		
		return productCategoryService.getProductCategory(category, currentPageNo, pageSize);
	}

	@RequestMapping("/add")
	// 添加商品类别
	public boolean Add(ProductCategory pc) throws Exception {
		return productCategoryService.AddProductCategory(pc);
	}

	@RequestMapping("/modify")
	// 修改商品类别
	public boolean Modify(ProductCategory pc, Integer id) throws Exception {
		return productCategoryService.ModifyProductCategory(pc, id);
	}

	@RequestMapping("/delete")
	// 删除商品类别
	public boolean Delete(Integer id) throws Exception {
		return productCategoryService.DeleteProductCategory(id);
	}

	@RequestMapping("/queryAll")
	// 查询商品
	public List<Product> getProductById(Integer id) throws Exception {
		return productCategoryService.getProductById(id);
	}

	@RequestMapping("/count")
	// 统计商品类别数量
	public int Count(String category) throws Exception {
		return productCategoryService.getcount(category);
	}
}
