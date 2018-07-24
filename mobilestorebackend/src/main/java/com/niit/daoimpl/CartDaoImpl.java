package com.niit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.CartDao;
import com.niit.model.CartModel;

@Repository
public class CartDaoImpl implements CartDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	public void save(CartModel cart1)
	{
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.save(cart1);
		s.getTransaction().commit();
		s.close();
		
	}

	public CartModel getId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(CartModel cart) {
		// TODO Auto-generated method stub
		
	}

/*	public void delete(CartModel p)
	{
		
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(p);
		s.getTransaction().commit();
		s.close();

	} */ 
	public List<CartModel> getAll() 
	{
		Session s=sessionFactory.openSession();
		List<CartModel> clist=s.createCriteria(CartModel.class).list();
		s.clear();
		return clist;
	}
	public CartModel findById(int id) 
	{
		
		
		return (CartModel)sessionFactory.openSession().get(CartModel.class,id);
	}

	@Override
	public void deleteById(CartModel cart) {
		Session s=sessionFactory.openSession();
		s.beginTransaction();
		s.delete(cart);
		s.getTransaction().commit();
		s.close();
	}

	
	      
		
}
