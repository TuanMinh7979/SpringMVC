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
	public List<Product> getProducts(String kw, int page) {
		// TODO Auto-generated method stub
		Session ss = this.ses.getObject().getCurrentSession();
		CriteriaBuilder builder = ss.getCriteriaBuilder();
		CriteriaQuery<Product> Cq = builder.createQuery(Product.class);
		Root root = Cq.from(Product.class);

		Cq = Cq.select(root);

		if (kw != null && !kw.isEmpty()) {
			Predicate p = builder.like(root.get("name").as(String.class), String.format("%%%s%%", kw));
			Cq = Cq.where(p);
		}
		Query q = ss.createQuery(Cq);

		int max = 3;
		q.setMaxResults(max);
		q.setFirstResult((page - 1) * max);

		return q.getResultList();
	}

	@Override
	public boolean addOrUpdate(Product product) {
		Session session = this.ses.getObject().getCurrentSession();

		try {
			session.save(product);
			return true;
		} catch (Exception ex) {
			System.err.println("==ADD product Err" + ex.getMessage());
			ex.printStackTrace();

		}
		return false;
	}

	@Override
	public long countProduct() {
		Session session = this.ses.getObject().getCurrentSession();
		Query q = session.createQuery("Select Count(*) From Product");
		return Long.parseLong(q.getSingleResult().toString());
	}

	@Override
	public Product getProductById(int productId) {
		// TODO Auto-generated method stub
		Session session = this.ses.getObject().getCurrentSession();
		return session.get(Product.class, productId);
	}

}
