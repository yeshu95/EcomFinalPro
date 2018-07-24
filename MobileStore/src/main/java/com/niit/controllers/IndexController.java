package com.niit.controllers;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.model.CartModel;
import com.niit.model.CategoryModel;
import com.niit.model.ProductsModel;
import com.niit.model.SupplierModel;
import com.niit.model.UserModel;
import com.niit.dao.CartDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductsDao;
import com.niit.dao.SupplierDao;
import com.niit.dao.UserDao;;

@Controller
public class IndexController {
	@Autowired
	public UserDao user1;
	@Autowired
	public ProductsDao proDao;
	@Autowired
	public SupplierDao supDao;
	@Autowired
	public CategoryDao catsDao;
	@Autowired
	public CartDao cartDao;
	
	
	@RequestMapping( "/")
	public ModelAndView welcome() 
	{
		List<CategoryModel> list=catsDao.getAllCategoryDetails();
	    List<SupplierModel> slist=supDao.getAllCategories();
	    
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("clist", list);
		//mv.addObject("slist",slist);
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView login() 
	{
		 ModelAndView mv = new ModelAndView("login");
		  return mv;
	}
	   @RequestMapping(value="/reg")
	  	public ModelAndView regpage()
	  	{
	  		ModelAndView m2=new ModelAndView("registerpage");
	  		return m2;
	  		
	  	}
	   @RequestMapping(value="/proDescription")
	  	public ModelAndView proDescription()
	  	{
	  		ModelAndView m2=new ModelAndView("proDescription");
	  		return m2;
	  		
	  	}
	   @RequestMapping(value ="/registerpage")
	   public ModelAndView addUser(HttpServletRequest request)
	   {
			
		   int u_id=Integer.parseInt(request.getParameter("uid"));
		   
		   String u_name=request.getParameter("username");
		   
		   String u_pass=request.getParameter("userpass");
		   
		   String u_addr=request.getParameter("useraddress");
		   
		   String u_mail=request.getParameter("email");
		   
		   String u_age=request.getParameter("age");
	
		   String u_phone=request.getParameter("userphone");
		 
		   
		   String u_gen=request.getParameter("gen");
		   
		   
		   
		   UserModel u=new UserModel();
		   u.setUser_Id(u_id);
		   u.setUserName(u_name);
		   u.setUserPassword(u_pass);
		   u.setUserAge(u_age);
		   u.setUser_Gender(u_gen);
		   u.setUser_Phone(u_phone);
		   u.setUserMailId(u_mail);
		   u.setUser_Address(u_addr);
		   u.setUserRole("User");
		  /* u.setUserid(u_id);
		   u.setName(u_name);
		   u.setPassword(u_pass);
		   u.setAddress(u_addr);
		   u.setEmail(u_mail);
		   u.setAge(u_age);
		   u.setCity(u_city);
		   u.setPhone(u_phone);
		   u.setGender(u_gen);
		   u.setRole("User");*/
		   user1.addUser(u);
			System.out.println(u.getUser_Id());
			
			ModelAndView mv = new ModelAndView("index");
			return mv;
	   }
	
	   @RequestMapping(value ="/admin/product_delete")
	    public ModelAndView delete(HttpServletRequest request)
	    {
			
			ProductsModel p=proDao.findById(request.getParameter("id"));
			System.out.print(p);
			proDao.delete(p);
		    List<ProductsModel> list=proDao.getAllProdcutsDetails();
		    ModelAndView mv = new ModelAndView("Adding");	
		    mv.addObject("list",list);
		   return mv;
		 
	    }
	   @RequestMapping(value="/admin/product_edit")
		public ModelAndView editProducts(HttpServletRequest request){	
		String id=request.getParameter("id");
		System.out.println(id);
		ModelAndView mv=new ModelAndView("productEdit");
		List<CategoryModel> list=catsDao.getAllCategoryDetails();
		List<SupplierModel> slist=supDao.getAllSupplier();
		System.out.println(proDao.findById(id).toString());
		mv.addObject("product",proDao.findById(id) );	
		mv.addObject("slist", slist);
		mv.addObject("clist", list);
		return mv;
		}
	  
	   @RequestMapping(value = "/admin/product_update", method = RequestMethod.POST)
		public  ModelAndView updateProduct(@RequestParam("file") MultipartFile file ,HttpServletRequest request) 
		{ 
			System.out.println("in Products Controller");
			String id=request.getParameter("p_id");
			String pname=request.getParameter("p_name");
			String pdesc=request.getParameter("p_desc");
			int price=Integer.parseInt(request.getParameter("p_price"));
			String cid=request.getParameter("c_id");
			String sid=request.getParameter("s_id");
			CategoryModel c=catsDao.getCategoryDetail(cid);
			SupplierModel s=supDao.getSupplierDetails(sid);
			ProductsModel p=new ProductsModel();
			p.setProdCategory(c);
			p.setProdDescription(pdesc);
			p.setProdName(pname);
			p.setProdPrice(price);
			p.setProdId(id);	
			String originalfile = file.getOriginalFilename();
			p.setProImage(originalfile);
			p.setProdSupplier(s);
			
			proDao.updateCategoryDetail(p);
			String filepath = request.getSession().getServletContext().getRealPath("/");
			System.out.println(filepath+originalfile);
			try {
				byte imagebyte[] = file.getBytes();
				BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(filepath+"./resources/image/"+originalfile));
				fos.write(imagebyte);
				fos.close();
				} catch (IOException e) {
				e.printStackTrace();
				} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
			
		
			List<CategoryModel> list=catsDao.getAllCategoryDetails();
			List<SupplierModel> slist=supDao.getAllSupplier();
			
		
			//ModelAndView mv = new ModelAndView("productList");
			ModelAndView mv = new ModelAndView("index");
			mv.addObject("slist", slist);
			mv.addObject("clist", list);
			return mv;
		}
	   @RequestMapping({"/productlistView","/admin/productlistView"})
	 // @RequestMapping("/admin/productlistView")
		public ModelAndView productListFilter(HttpServletRequest request)
		{ 
			List<ProductsModel> clist=proDao.getFilterProducts(Integer.valueOf(request.getParameter("id")));
			List<ProductsModel> list=proDao.getAllProducts();
			ModelAndView mv = new ModelAndView("productlistView");	
			mv.addObject("list",clist);
			return mv;
		}
	   @ModelAttribute
		  public void addAttributes(Model model)
		  {
			  model.addAttribute("clist",catsDao.getAllCategoryDetails());
		  }
	@RequestMapping({"/product","/admin/product"})
	
	public ModelAndView product(HttpServletRequest request) 
	{
		
        String id=request.getParameter("id");
        ProductsModel p=proDao.findById(id);
		ModelAndView mv = new ModelAndView("proDescription");
		List<CategoryModel> c=catsDao.getAllCategoryDetails();
		mv.addObject("list",c);
		mv.addObject("product", p);
		
		return mv;
	}
	@RequestMapping("/productdetails")
	public ModelAndView addCarttable(HttpServletRequest request) 
	{
		
		String id=request.getParameter("prodid");
		
		int quan=Integer.valueOf(request.getParameter("prodquantity"));
		
		int price=Integer.valueOf(request.getParameter("prodprice"));
		/*int uid=Integer.valueOf(request.getParameter("userid"));
		int sid=Integer.valueOf(request.getParameter("suplierid"));*/
		
		/*UserModel c=user1.findById(uid);
		SupplierModel s=supplierDAO.findById(sid);*/
		System.out.println(""+id+""+quan+""+price);
		ProductsModel p=proDao.findById(id);
		CartModel g=new CartModel();
		g.setPrices(price);
		g.setQuantity(quan);
		g.setProductid(p);
		/*g.setSuplierid(s);
		g.setUserid(c);*/
		
		
		cartDao.save(g);
		
		ModelAndView mv = new ModelAndView("viewCart");
		List<CartModel> cartList=cartDao.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
		
	}
	/*@RequestMapping("/cart_delete")
	public ModelAndView editCart(HttpServletRequest request)
	{
		int cid=Integer.valueOf(request.getParameter("id"));
		CartModel c=cartDao.findById(cid);
		cartDao.deleteById(c);
		
		ModelAndView mv=new ModelAndView("viewcartdetail");
		List<CartModel> cartList=cartDao.getAll();
		
		mv.addObject("cartlist", cartList);
		return mv;
	}*/
}
