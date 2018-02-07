package com.situ.mall.controller.back;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.situ.mall.common.ServerResponse;
import com.situ.mall.constant.Const;
import com.situ.mall.entity.Product;
import com.situ.mall.entity.User;
import com.situ.mall.service.IProductService;
import com.situ.mall.service.IUserService;

@Controller
@RequestMapping("manager/product")
public class ProductManagerController {
	@Autowired
	private IProductService productService;
	
	@RequestMapping("/pageList")
	 	@ResponseBody
	 	public ServerResponse<List<Product>> pageList(Integer page, Integer limit,Product product) {
	 		return productService.pageList(page, limit,product);
	 	}
	@RequestMapping("/deleteById")
	@ResponseBody
	public ServerResponse deleteById(Integer id){
		return productService.deleteById(id);
	}
	@RequestMapping("/deleteAll")
	@ResponseBody
	public ServerResponse deleteAll(String ids){
		return productService.deleteAll(ids);
	}
	 	
	 	@RequestMapping("/getProductPage")
	 	public String getUserPage() {
	 		return "product_list";
	 	}
	 
}
