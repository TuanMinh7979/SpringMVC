package com.StaticRs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.StaticRs.pojo.Product;
import com.StaticRs.service.ProductService;
import com.StaticRs.validator.WebAppValidator;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	private ProductService productSv;
	@Autowired
	private WebAppValidator productValidator;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(productValidator);
	}

	@GetMapping("/products")
	public String list(Model model) {
		model.addAttribute("product", new Product());
		return "products";
	}

	@PostMapping("/products")
	public String add(Model model, HttpServletRequest req, @ModelAttribute(value = "product") @Valid Product newProduct,
			BindingResult rs) {
		System.out.println("VAO DAY");
//		MultipartFile img = newProduct.getFile();
//		String rootdir = "C:\\Users\\ASUS\\eclipse-workspace\\StaticResoure\\src\\main\\webapp\\resources\\img\\";
//		System.out.println("REAL PATH IS: " + rootdir);

		if (!rs.hasErrors()) {
			if(productSv.addOrUpdate(newProduct)) {
				return "redirect:/";
			}else {
				model.addAttribute("errMsg","Something wrongs!");
			}
		}

		return "products";

	}

}
