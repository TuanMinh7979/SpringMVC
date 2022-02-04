package com.StaticRs.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.StaticRs.pojo.Product;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@GetMapping("/products")
	public String list(Model model) {
		model.addAttribute("product", new Product());
		return "products";
	}

	@PostMapping("/products")
	public String add(HttpServletRequest req, @ModelAttribute(value = "product") @Valid Product newProduct,
			BindingResult rs) {
		System.out.println("VAO DAY");
		MultipartFile img = newProduct.getFile();
		String rootdir = req.getSession().getServletContext().getRealPath("/");
		System.out.println("REAL PATH IS: " + rootdir);

		if (!rs.hasErrors()) {
			try {
				img.transferTo(new File(rootdir + "resources/img/" + newProduct.getFile().getName() + ".jpg"));
				return "redirect:/";

			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				System.out.println("co loi xay ra khi upload");
				e.printStackTrace();

			}
		}

		return "products";

	}

}
