package com.StaticRs.repo.impl;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.StaticRs.pojo.Category;
import com.StaticRs.repo.CategoryRepo;

@Repository
public class CategoryRepoImpl implements CategoryRepo {
	@Autowired
	private LocalSessionFactoryBean ses;

	@Override
	@Transactional
	public List<Category> getCategories() {
		Session s = ses.getObject().getCurrentSession();
		Query q = s.createQuery("FROM Category");
		return q.getResultList();

	}

}
