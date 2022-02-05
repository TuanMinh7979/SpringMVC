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
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "products2")
public class Product implements Serializable {

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<Nsx> getNsxS() {
		return nsxS;
	}

	public void setNsxS(Set<Nsx> nsxS) {
		this.nsxS = nsxS;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

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

	public Category getCategory() {
		return category1;
	}

	public void setCategory(Category category) {
		this.category1 = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Size(min = 5, max = 100, message = "{product.name.sizeErr}")
	private String name;
	private String description;
	@Min(value = 10000, message = "{product.price.minErr}")
	@Max(value = 10000000, message = "{product.price.maxErr}")
	private BigDecimal price;
	private String image;

	@Column(name = "created_date")
	@Temporal(javax.persistence.TemporalType.DATE)
	private Date createDate;
	private int active;

	// many to one thi phai la eager
	@ManyToOne
	@JoinColumn(name = "category_id")
	@NotNull(message = "{product.category1.nullErr}")
	private Category category1;
	@ManyToMany
	@JoinTable(name = "product_nsx", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
			@JoinColumn(name = "nsx_id") })
	private Set<Nsx> nsxS;
	@Transient
	private MultipartFile file;

	public Product() {

	}

	public Product( @Size(min = 5, max = 100, message = "{product.name.sizeErr}") String name,
			String description,
			@Min(value = 10000, message = "{product.price.minErr}") @Max(value = 10000000, message = "{product.price.maxErr}") BigDecimal price,
			String image, Date createDate, int active,
			@NotNull(message = "{product.category1.nullErr}") Category category1, Set<Nsx> nsxS, MultipartFile file) {
		super();
		
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.createDate = createDate;
		this.active = active;
		this.category1 = category1;
		this.nsxS = nsxS;
		this.file = file;
	}
}
