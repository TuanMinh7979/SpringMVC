package com.StaticRs.repo;

import java.util.List;

import com.StaticRs.pojo.Product;

public interface ProductRepo {
	List<Product> getProducts(String kw, int page);

	long countProduct();

	boolean addOrUpdate(Product product);

	Product getProductById(int productId);
}
