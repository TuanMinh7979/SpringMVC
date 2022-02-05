package com.StaticRs.service;

import java.util.List;
import java.util.Map;

import com.StaticRs.pojo.Product;

public interface ProductService  {
	List<Product> getProducts(String kw, int page);
	boolean addOrUpdate(Product product);
	long countProduct();
}
