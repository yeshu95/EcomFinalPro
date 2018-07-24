package com.niit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductsDao;
import com.niit.model.ProductsModel;
@Controller
public class productList {
	@Autowired
	ProductsDao products;
	@Autowired
	CategoryDao catsDao;
	@RequestMapping(value ="admin/productList")
	
    public ModelAndView add() {
       
		List<ProductsModel>list=products.getAllProdcutsDetails();
	 ModelAndView c1=new ModelAndView("productlist");
	 c1.addObject("slist", list);
		return c1;
    }
	@ModelAttribute
	  public void addAttributes(Model model)
	  {
		  model.addAttribute("clist",catsDao.getAllCategoryDetails());
	  }
}
