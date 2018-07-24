package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.CategoryModel;

@Controller
public class categoryList 
{
	@Autowired
	CategoryDao category;
	@RequestMapping(value ="admin/categoryList")
    public ModelAndView add() {
        
	
	 List<CategoryModel>list=category.getAllCategoryDetails();
	 ModelAndView c1=new ModelAndView("categoryList");
	 c1.addObject("clist", list);
		return c1;
    }

}