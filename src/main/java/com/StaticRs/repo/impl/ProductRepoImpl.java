package com.StaticRs.repo.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.StaticRs.pojo.Product;
import com.StaticRs.repo.ProductRepo;

@Repository
@Transactional
public class ProductRepoImpl implements ProductRepo {
	@Autowired
	private LocalSessionFactoryBean ses;

	@Override
	public List<Product> getProducts(String kw) {
		// TODO Auto-generated method stub
		Session ss = this.ses.getObject().getCurrentSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Product> Cq = builder.createQuery(Product.class);
		Root root = Cq.from(Product.class);

		Cq = Cq.select(root);
		if (!kw.isEmpty() && kw != null) {
			Predicate p = builder.like(root.get("name").as(String.class), String.format("%%s%%", kw));
	        Cq=Cq.where(p);	
		}
		Query q = ss.createQuery(Cq);
		return q.getResultList();
	}
}
