package com.StaticRs.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.StaticRs.pojo.Product;

public interface ProductRepo {
List<Product> getProducts(String kw);
}
