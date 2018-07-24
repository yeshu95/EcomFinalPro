package com.niit.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="OrderDetails",uniqueConstraints = {
		@UniqueConstraint(columnNames = "order_Id")})
public class OrdersModel implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="order_Id")
	private Integer order_Id;
	@Column(name="order_User_Id")
	private String order_User_Id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private UserModel orderUserDetails;
	@Column(name="order_Payment")
	private String orderPayment;
	@Column(name="order_Total")
	private double orderTotal;
	
	public OrdersModel()
	{
		
	}
	public OrdersModel(Integer orderId,String orderUserId,UserModel orderUserDetails,String orderPayment,double orderTotal)
	{
		this.order_Id=orderId;
		this.order_User_Id=orderUserId;
		this.orderUserDetails=orderUserDetails;
		this.orderPayment=orderPayment;
		this.orderTotal=orderTotal;
		
	}
	public Integer getOrderId() {
		return order_Id;
	}
	public void setOrderId(Integer orderId) {
		this.order_Id = orderId;
	}
	public String getOrderUserId() {
		return order_User_Id;
	}
	public void setOrderUserId(String orderUserId) {
		this.order_User_Id = orderUserId;
	}
	public UserModel getOrderUserDetails() {
		return orderUserDetails;
	}
	public void setOrderUserDetails(UserModel orderUserDetails) {
		this.orderUserDetails = orderUserDetails;
	}
	public String getOrderPayment() {
		return orderPayment;
	}
	public void setOrderPayment(String orderPayment) {
		this.orderPayment = orderPayment;
	}
	public double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}
	
}
