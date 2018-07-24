package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.ProductsDao;
import com.niit.model.ProductsModel;
@Repository
public class ProductsDaoImpl implements ProductsDao {

    
    @Autowired
    SessionFactory sessionFactory;
    public List<ProductsModel> getAllProdcutsDetails() {
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        
        List<ProductsModel> product=sessionFactory.openSession().createCriteria(ProductsModel.class).list();
        //List<ProductsModel> product=sessionFactory.openSession().createCriteria(ProductsModel.class).list();
        
        session.getTransaction().commit();
        
        return product;
    }

   /* public ProductsModel getCategoryDetail(String id) {
    	ProductsModel p=(ProductsModel)sessionFactory.openSession().get(ProductsModel.class, id);

        // TODO Auto-generated method stub
        return p;
    }*/

    public void updateCategoryDetail(ProductsModel obj) {
        // TODO Auto-generated method stub
    	   Session s=sessionFactory.openSession();
           s.beginTransaction();
           s.update(obj);
           s.getTransaction().commit();
           s.close(); 
    }
    public ProductsModel findById(String id) {
		
		// TODO Auto-generated method stub
		return sessionFactory.openSession().get(ProductsModel.class,id);
	}

    public void addProducts(ProductsModel obj) 
    {
        System.out.println("Product Implementation");


        Session s=sessionFactory.openSession();
        s.beginTransaction();
        s.save(obj);
        s.getTransaction().commit();
        s.close();
        
    }
 
	public List<ProductsModel> getAllProducts() {
		 Session sf =sessionFactory.openSession();
	        sf.beginTransaction();
	        Query query = sf.createQuery("from ProductsModel");
	        List<ProductsModel> slist=query.list();
	        System.out.println(slist);
	        sf.getTransaction().commit();
	        return slist;
	}

	public void delete(ProductsModel obj) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(obj);
		s.getTransaction().commit();
		s.close();sessionFactory.openSession().delete(obj);
		
	}
	public List<ProductsModel> getFilterProducts(int cid)
	{
		Session s=sessionFactory.openSession();
		
		List<ProductsModel> results =s.createQuery("from ProductsModel where CATEGORYID="+cid).list();
		s.close();
		// TODO Auto-generated method stub
		return results;
	}
	public ProductsModel getCategoryDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
