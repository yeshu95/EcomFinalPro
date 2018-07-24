package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.UserDao;
import com.niit.model.UserModel;

public class userlist {
	@Autowired
	UserDao users;
	@Autowired
	CategoryDao catsDao;
	@RequestMapping(value ="/userlist")
    public ModelAndView add() {
    List<UserModel>list=users.getAllUserDetails();
	 ModelAndView c1=new ModelAndView("userlist");
	 c1.addObject("clist", list);
		return c1;
    }
	@ModelAttribute
	  public void addAttributes(Model model)
	  {
		  model.addAttribute("clist",catsDao.getAllCategoryDetails());
	  }
}
