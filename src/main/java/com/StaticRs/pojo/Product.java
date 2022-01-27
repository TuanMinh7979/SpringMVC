package com.StaticRs.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "products2")
public class Product implements Serializable {

	public Category getCategory1() {
		return category1;
	}

	public void setCategory1(Category category1) {
		this.category1 = category1;
	}

	public Set<Nsx> getNsxs() {
		return nsxS;
	}

	public void setNsxs(Set<Nsx> nsxs) {
		nsxS = nsxs;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Category getCategory() {
		return category1;
	}

	public void setCategory(Category category) {
		this.category1 = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	private BigDecimal price;
	private String image;

	@Column(name = "created_date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createDate;
	private boolean active;

	// many to one thi phai la eager
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category1;
	@ManyToMany
	@JoinTable(name = "product_nsx", 
	       joinColumns = { @JoinColumn(name = "product_id") },
	       inverseJoinColumns = {@JoinColumn(name = "nsx_id") })
	private Set<Nsx> nsxS;

	public Product() {

	}
}
