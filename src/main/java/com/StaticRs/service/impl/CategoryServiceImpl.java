package com.StaticRs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StaticRs.pojo.Category;
import com.StaticRs.repo.CategoryRepo;
import com.StaticRs.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo repo;

	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return this.repo.getCategories();
	}

}
