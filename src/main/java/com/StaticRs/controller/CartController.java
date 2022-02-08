package com.StaticRs.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.StaticRs.pojo.CartItem;

@Controller
public class CartController {

	@GetMapping("/cart")
	public String cart(Model model, HttpSession session) {
		Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("carts");
		if (cart != null) {
			model.addAttribute("carts", cart.values());
			System.out.println("SIZE LA "+cart.values().size());
		} else {
			model.addAttribute("carts", null);
		}
		return "cart";
	}
}
