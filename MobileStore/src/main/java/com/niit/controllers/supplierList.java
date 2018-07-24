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
import com.niit.dao.SupplierDao;
import com.niit.model.ProductsModel;
import com.niit.model.SupplierModel;

@Controller
public class supplierList 
{
	@Autowired
	SupplierDao supplier;
	@Autowired
	CategoryDao catsDao;
	@RequestMapping(value ="admin/supplierList")
    public ModelAndView add() {
		List<SupplierModel>list=supplier.getAllSupplier();  
	 ModelAndView c1=new ModelAndView("supplierList");
	 c1.addObject("list", list);
	return c1;
    }
	@ModelAttribute
	  public void addAttributes(Model model)
	  {
		  model.addAttribute("clist",catsDao.getAllCategoryDetails());
	  }
}