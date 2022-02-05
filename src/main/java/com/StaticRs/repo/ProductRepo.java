package com.StaticRs.repo;

import java.util.List;

import com.StaticRs.pojo.Product;

public interface ProductRepo {
List<Product> getProducts(String kw);
boolean addOrUpdate (Product product);
}
