package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author HOC
 *
 */
@Entity
@Table(name = "Products", uniqueConstraints = { @UniqueConstraint(columnNames = "prodId") })
public class ProductsModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "prodId")
	private String prodId;

	@Column(name = "prod_Brand")
	private String prodBrand;

	@Column(name = "prod_Name")
	private String prodName;

	@Column(name = "prod_Description")
	private String prodDescription;

	@ManyToOne
	/* @JoinColumn(name = "category_Id") */
	@JoinColumn(name = "categoryid")
	private CategoryModel prodCategory;
	

	@ManyToOne
	@JoinColumn(name = "supplierId")
	private SupplierModel prodSupplier;

	
	@Column(name = "prod_Price")
	private int prodPrice;

	@Column(name = "proImage")
	private String proImage;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public String getProdBrand() {
		return prodBrand;
	}

	public void setProdBrand(String prodBrand) {
		this.prodBrand = prodBrand;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public CategoryModel getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(CategoryModel prodCategory) {
		this.prodCategory = prodCategory;
	}

	public SupplierModel getProdSupplier() {
		return prodSupplier;
	}

	public void setProdSupplier(SupplierModel prodSupplier) {
		this.prodSupplier = prodSupplier;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProImage() {
		return proImage;
	}

	public void setProImage(String proImage) {
		this.proImage = proImage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ProductsModel(String prodId, String prodBrand, String prodName, String prodDescription,
			CategoryModel prodCategory, SupplierModel prodSupplier, int prodPrice, String proImage) {
		super();
		this.prodId = prodId;
		this.prodBrand = prodBrand;
		this.prodName = prodName;
		this.prodDescription = prodDescription;
		this.prodCategory = prodCategory;
		this.prodSupplier = prodSupplier;
		this.prodPrice = prodPrice;
		this.proImage = proImage;
	}

	public ProductsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ProductsModel [prodId=" + prodId + ", prodBrand=" + prodBrand + ", prodName=" + prodName
				+ ", prodDescription=" + prodDescription + ", prodCategory=" + prodCategory + ", prodSupplier="
				+ prodSupplier + ", prodPrice=" + prodPrice + ", proImage=" + proImage + "]";
	}

	

	/*
	 * private Set<Category> category_Ids=new HashSet<Category>( 0);
	 * 
	 * 
	 * private Set<Supplier> supplier_Ids=new HashSet<Supplier>( 0);
	 */
	
}
