package com.StaticRs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StaticRs.pojo.Product;
import com.StaticRs.repo.ProductRepo;
import com.StaticRs.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepo repo;
	@Override
	public List<Product> getProducts(String kw) {
		// TODO Auto-generated method stub
		return repo.getProducts(kw);
	}



 

}
