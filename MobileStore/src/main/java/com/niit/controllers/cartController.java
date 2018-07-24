package com.niit.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.ProductsDao;
import com.niit.model.CartModel;
import com.niit.model.ProductsModel;

@Controller
public class cartController 
{
	@Autowired
	ProductsDao pdao;
	
	@Autowired
	CartDao cdao;
	
	@RequestMapping("/viewCart")
	public ModelAndView viewCart(){
		
		ModelAndView mv=new ModelAndView("viewCart");
		List<CartModel> cartList=cdao.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}
	@RequestMapping("/addCart")
	public ModelAndView addCart(HttpServletRequest request){
		String id=request.getParameter("prodid");
		int q=Integer.valueOf(request.getParameter("prodquantity"));
		
		ProductsModel p=pdao.findById(id);
		int price=Integer.valueOf(p.getProdPrice());
		CartModel c=new CartModel();
	    c.setPrices(price);
		c.setQuantity(q);
		c.setProductid(p);
		
		
		
		cdao.save(c);
		
		System.out.println(c);
		
		ModelAndView mv=new ModelAndView("viewCart");
		List<CartModel> cartList=cdao.getAll();
		System.out.println(cartList);
		
		mv.addObject("cartlist", cartList);
		return mv;
		
	}
	@RequestMapping("/cart_delete")
	public ModelAndView editCart(HttpServletRequest request)
	{
		int cid=Integer.valueOf(request.getParameter("id"));
		CartModel c=cdao.findById(cid);
		cdao.deleteById(c);
		
		ModelAndView mv=new ModelAndView("viewCart");
		List<CartModel> cartList=cdao.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}


}