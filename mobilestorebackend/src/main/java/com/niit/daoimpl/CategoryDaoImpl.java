package com.niit.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CategoryDao;

import com.niit.model.CategoryModel;
@Repository
public class CategoryDaoImpl implements CategoryDao
{
	 @Autowired
	    SessionFactory sessionFactory;
	  public List<CategoryModel> getAllCategoryDetails() {
	        
	        Session sf =sessionFactory.openSession();
	        sf.beginTransaction();
	        Query query = sf.createQuery("from CategoryModel");
	        List<CategoryModel> list=query.list();
	        System.out.println(list);
	        sf.getTransaction().commit();
	        return list;
	        
	    }
	        
	    
	        
	    /*    Session session=sessionFactory.openSession();
	        List<Category> category=null;
	        session.beginTransaction();
	        category=session.createQuery("from Category").list();
	        session.getTransaction().commit();
	        
	        return category;*/
	    

	    public CategoryModel getCategoryDetail(String id) {
	        
	    	CategoryModel c=(CategoryModel)sessionFactory.openSession().get(CategoryModel.class, id);
	        // TODO Auto-generated method stub
	        return c;
	    }

	    public void updateCategoryDetail(CategoryModel obj) {
	        // TODO Auto-generated method stub
	        
	    }

	    public void addCategory(CategoryModel obj)
	    {
	        Session s=sessionFactory.openSession();
	        s.beginTransaction();
	        s.save(obj);
	        s.getTransaction().commit();
	        s.close();
	        // TODO Auto-generated method stub
	        
	    }



		public void deleteProduct(CategoryModel entity) {
			// TODO Auto-generated method stub
			
		}







}