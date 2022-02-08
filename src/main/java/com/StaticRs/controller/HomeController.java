package com.StaticRs.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.StaticRs.Utils;
import com.StaticRs.pojo.CartItem;
import com.StaticRs.service.CategoryService;
import com.StaticRs.service.ProductService;

@Controller
@ControllerAdvice
public class HomeController {
	@Autowired
	private CategoryService categorySv;
	@Autowired
	private ProductService productSv;

	@ModelAttribute
	public void commonAttr(Model model, HttpSession session) {
		model.addAttribute("categories", this.categorySv.getCategories());
		model.addAttribute("cartCounter", Utils.countCart((Map<Integer, CartItem>) session.getAttribute("carts")));
	}

	@RequestMapping("/")
	public String Trangchu(Model model, @RequestParam(required = false) Map<String, String> param) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		model.addAttribute("products", this.productSv.getProducts(param.get("kw"), page));
        model.addAttribute("counter", this.productSv.countProduct());
		return "index";
	}
}
