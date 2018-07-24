package com.niit.dao;

import java.util.List;

import com.niit.model.UserModel;

public interface UserDao {
	List<UserModel> getAllUserDetails();
	
	UserModel getUserDetail(String id);
	
	void updateUserDetail(UserModel obj);
	void addUser(UserModel obj);

	void deleteUser(UserModel entity);
}
