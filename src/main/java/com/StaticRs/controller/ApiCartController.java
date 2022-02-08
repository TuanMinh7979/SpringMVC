package com.StaticRs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.StaticRs.Utils;
import com.StaticRs.pojo.CartItem;
import com.StaticRs.pojo.Product;
import com.StaticRs.service.ProductService;

@RestController
public class ApiCartController {
	@Autowired
	private ProductService productService;

//khong muon lay truong nao thi dung json ignore
	@GetMapping("/api/products")
	public ResponseEntity<List<Product>> listProducts() {
		List<Product> products = this.productService.getProducts("", 1);
		System.out.println("++++++++++++++++++++++");
		System.out.println(products.size());

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@GetMapping("/api/cart/{productId}")
	public ResponseEntity<Integer> cart(@PathVariable(value = "productId") Integer productId, HttpSession session) {
		Map<Integer, CartItem> carts = (Map<Integer, CartItem>) session.getAttribute("carts");
		if (carts == null)
			carts = new HashMap<>();
		Product p = productService.getProductById(productId);
		if (carts.containsKey(productId)) {
			CartItem c = carts.get(productId);
			c.setCount(c.getCount() + 1);
		} else {
			CartItem c = new CartItem();
			c.setProductId(p.getId());
			c.setName(p.getName());
			c.setPrice(p.getPrice());
			c.setCount(1);

			carts.put(productId, c);
		}
		session.setAttribute("carts", carts);
//		System.out.println("===CART===" + Utils.countCart(carts));
		//day se tich hop san request body
		return new ResponseEntity<>(Utils.countCart(carts), HttpStatus.OK);

	}

}
