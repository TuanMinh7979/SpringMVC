package com.StaticRs.repo;

import java.util.List;

import com.StaticRs.pojo.Category;

public interface CategoryRepo {
//	default List<Category> getCategories1(){
//		return null;
//	}
	
    List<Category> getCategories();
}
