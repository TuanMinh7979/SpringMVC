package com.StaticRs.pojo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "nsx")
public class Nsx implements Serializable {
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	public Nsx() {

	}

	public Nsx(int id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
	}

	private String name;
	private String country;

	@ManyToMany(mappedBy = "nsxS", fetch = FetchType.LAZY)
	private Set<Product> products;
}
