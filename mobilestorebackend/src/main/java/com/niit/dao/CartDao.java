package com.niit.dao;

import java.util.List;

import com.niit.model.CartModel;

public interface CartDao {
	public void save(CartModel cart);
	public CartModel getId(int id);
	//update
	public void update(CartModel cart);
	//deleted
	public void deleteById(CartModel id);
	//Get All
	public List<CartModel> getAll();
	public CartModel findById(int id);
}
