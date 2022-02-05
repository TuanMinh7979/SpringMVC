package com.StaticRs.service;

import java.util.List;

import com.StaticRs.pojo.Product;

public interface ProductService  {
	List<Product> getProducts(String kw);
	boolean addOrUpdate(Product product);
}
