package com.niit.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.UserDao;
import com.niit.model.UserModel;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	 @Autowired
	    SessionFactory sessionFactory;
	  public List<UserModel> getAllUserDetails() {
	        
	        Session sf =sessionFactory.openSession();
	        sf.beginTransaction();
	        Query query = sf.createQuery("from UserModel");
	        List<UserModel> list=query.list();
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
	    

	    public UserModel getUserDetail(String id) {
	        
	    	UserModel c=(UserModel)sessionFactory.openSession().get(UserModel.class, id);
	        // TODO Auto-generated method stub
	        return c;
	    }

	    public void updateUserDetail(UserModel obj) {
	        // TODO Auto-generated method stub
	        
	    }

	    public void addUser(UserModel obj)
	    {
	        Session s=sessionFactory.openSession();
	        s.beginTransaction();
	        s.save(obj);
	        s.getTransaction().commit();
	        s.close();
	        // TODO Auto-generated method stub
	        
	    }
		public void deleteUser(UserModel entity) {
			// TODO Auto-generated method stub
			
		}
}
