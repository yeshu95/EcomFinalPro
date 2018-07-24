package com.niit.dao;

import java.util.List;

import com.niit.model.ProductsModel;


public interface ProductsDao
{
	List<ProductsModel> getAllProdcutsDetails();
	
	ProductsModel getCategoryDetail(String id);
	
	void updateCategoryDetail(ProductsModel obj);
	
	void addProducts(ProductsModel obj);
	public List<ProductsModel> getAllProducts();
	public void delete(ProductsModel obj);
	public ProductsModel findById(String id);
	public List<ProductsModel> getFilterProducts(int cid);

}
