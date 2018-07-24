package com.niit.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Category")
public class CategoryModel implements Serializable
{
	   private static final long serialVersionUID = 1L;
       @Id
       @NotNull(message="Please fill all Data")
       @Column(name="categoryId")
       private String categoryId;
       @NotNull(message="Please fill all Data")
       @Column(name="categoryName")
       private String categoryName;

       @OneToMany(targetEntity=ProductsModel.class, fetch = FetchType.EAGER, mappedBy = "prodCategory", cascade=CascadeType.ALL)
       @Column(name="category_Products")
       private Set<ProductsModel> categoryProducts;/*=new HashSet<Product>(0);*/

       public CategoryModel()
       {
           super();
       }

       public CategoryModel(String categoryId, String categoryName, Set<ProductsModel> categoryProducts) {
           super();
           this.categoryId = categoryId;
           this.categoryName = categoryName;
           this.categoryProducts = categoryProducts;
       }

       public String getCategoryId() {
           return categoryId;
       }

       public void setCategoryId(String categoryId) {
           this.categoryId = categoryId;
       }

       public String getCategoryName() {
           return categoryName;
       }

       public void setCategoryName(String categoryName) {
           this.categoryName = categoryName;
       }

       public Set<ProductsModel> getCategoryProducts() {
           return categoryProducts;
       }

       public void setCategoryProducts(Set<ProductsModel> categoryProducts) {
           this.categoryProducts = categoryProducts;
       }
       
       

}