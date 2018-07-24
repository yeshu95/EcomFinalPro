package com.niit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductsDao;
import com.niit.dao.SupplierDao;

@RestController
public class ListController {

	@Autowired
	private CategoryDao category;
	@Autowired
	private SupplierDao supplier;
	@Autowired
	private ProductsDao product;
	
	@RequestMapping(value = "/categorys", method = RequestMethod.GET)
	public @ResponseBody String getAllCategory() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(category.getAllCategoryDetails());

		return json;
	}

	@RequestMapping(value = "/suppliers", method = RequestMethod.GET)
	public @ResponseBody String getAllSupplier() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(supplier.getAllCategories());

		return json;
	}
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public @ResponseBody String getAllProdcutsDetails() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(product.getAllProducts());

		return json;
	}


}
