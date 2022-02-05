package com.StaticRs.repo;

import java.util.List;
import java.util.Map;

import com.StaticRs.pojo.Product;

public interface ProductRepo {
List<Product> getProducts( String kw, int page);
long countProduct();
boolean addOrUpdate (Product product);
}
