package com.niit.daoimpl;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.SupplierDao;
import com.niit.model.SupplierModel;

@Repository
public class SupplierDaoImpl implements SupplierDao
{
	 @Autowired
	    SessionFactory sessionFactory;
	 
		    public List<SupplierModel> getAllSupplier() {
		    	
		            Session session=sessionFactory.openSession();
		            session.beginTransaction();   
		            List<SupplierModel> supplier=sessionFactory.openSession().createCriteria(SupplierModel.class).list();
		            session.getTransaction().commit();
		           return supplier;
		        }

	    public SupplierModel getSupplierDetails(String id) {
	        SupplierModel s = sessionFactory.openSession().get(SupplierModel.class, id);
	        return s;
	    }

	    public void updateSupplierDetail(SupplierModel obj) {
	        // TODO Auto-generated method stub
	        
	    }

	    public void addSupplier(SupplierModel obj) {
	        Session i=sessionFactory.openSession();
	        i.beginTransaction();
	        i.save(obj);
	        i.getTransaction().commit();
	        i.close();
	        // TODO Auto-generated method stub
	        
	    }

	    public void deleteProduct(SupplierModel entity) {
	        // TODO Auto-generated method stub
	        
	    }

	    public List<SupplierModel> getAllCategories() {
	        Session sf =sessionFactory.openSession();
	        sf.beginTransaction();
	        Query query = sf.createQuery("from SupplierModel");
	        List<SupplierModel> slist=query.list();
	        System.out.println(slist);
	        sf.getTransaction().commit();
	        return slist;
	    }

	
		

	}