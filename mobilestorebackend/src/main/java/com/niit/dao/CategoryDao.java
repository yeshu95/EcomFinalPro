package com.niit.dao;

import java.util.List;

import com.niit.model.CategoryModel;

public interface CategoryDao {
	
		List<CategoryModel> getAllCategoryDetails();
		
		public CategoryModel getCategoryDetail(String id);
		
		void updateCategoryDetail(CategoryModel obj);
		void addCategory(CategoryModel obj);
	
		void deleteProduct(CategoryModel entity);
		
}
