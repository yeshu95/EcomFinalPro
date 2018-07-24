package com.niit.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
@Entity
@Table(name="CartDetails",uniqueConstraints = {
		@UniqueConstraint(columnNames = "cartid")})
public class CartModel implements Serializable{ 
private static final long serialVersionUID = 1L;
	
	@Id
    private int cartid;
	private ProductsModel prodId;
	private SupplierModel suplierid;
	private UserModel userid;
	
	private int prices;
	private int quantity;
	//private int status;
	
	@Id
	@GeneratedValue
	@Column(name="cartid")//defining the database column
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	//In One productid display in cart
		@OneToOne
		@JoinColumn(name="prodId")
		public ProductsModel getProductid() {
			return prodId;
		}
		public void setProductid(ProductsModel prodId) {
			this.prodId = prodId;
		}
		/*@OneToOne
		@JoinColumn(name="suplierid")
		public SupplierModel getSuplierid() {
			return suplierid;
		}
		public void setSuplierid(SupplierModel suplierid) {
			this.suplierid = suplierid;
		}*/
		/*@OneToOne
		@JoinColumn(name="userid")
		public UserModel getUserid() {
			return userid;
		}
		public void setUserid(UserModel userid) {
			this.userid = userid;
		}*/
	@Column(name="prices")
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	@Column(name="quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
/*	@Column(name="status")
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}*/
	
	

}