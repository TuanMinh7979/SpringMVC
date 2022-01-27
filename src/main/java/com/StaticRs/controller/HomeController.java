package com.StaticRs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StaticRs.service.CategoryService;
import com.StaticRs.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	private CategoryService categorySv;
	@Autowired
	private ProductService productSv;
	@RequestMapping("/")
	public String Trangchu(Model model,@RequestParam(value="kw",required=false, defaultValue="" ) String kw) {
        model.addAttribute("categories",this.categorySv.getCategories());
		model.addAttribute("products", this.productSv.getProducts(kw));
		System.out.println("KEYWORD LA :  "+kw);
        return "index";
	}
}