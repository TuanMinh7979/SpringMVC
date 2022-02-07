package com.StaticRs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.StaticRs.pojo.User;
import com.StaticRs.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userDetailsService;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String registerView(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public String register(Model model, @ModelAttribute(value = "user") User user) {
		String errMsg = "";
		if (user.getPassword().equals(user.getConfirmPassword())) {
			if (this.userDetailsService.addUser(user))
				return "redirect:/login";
			else 
				errMsg="co loi khi luu data";
		} else {
			errMsg = "Mat khau khong khop";

		}
		model.addAttribute("errMsg", errMsg);
		return "register";
	}
}
