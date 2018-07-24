package com.niit.dao;

import java.util.List;

import com.niit.model.SupplierModel;

public interface SupplierDao {

	//Method for reading all category details
			List<SupplierModel> getAllSupplier();
			public SupplierModel getSupplierDetails(String id);
			
			void updateSupplierDetail(SupplierModel obj);
			void addSupplier(SupplierModel obj);
			void deleteProduct(SupplierModel entity);
			public List<SupplierModel> getAllCategories();
		
}
