package com.sathya.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.Daoimpl.CartDaoImpl;
import com.sathya.Daoimpl.ProductDaoImpl;
import com.sathya.model.Cart;
import com.sathya.model.Product;
@Controller
public class CartController
{
	
	@Autowired
	ProductDaoImpl productDaoImpl;
	@Autowired
	CartDaoImpl cartDaoImpl;
//	@RequestMapping("/addtocart")
//	 public String Addtocart(@RequestParam("proId") int productId)
//	 {
//	Product product = productDaoImpl.getProduct(productId);
//		 
//	AddTOCart addTOCart=addToCartDaoImpl.getsavetocart(product);
//		return null;
//		 
//	 }
	@RequestMapping("/Cart")
	 public ModelAndView Addtocart(HttpServletRequest httpServletRequest)
	 {
		ModelAndView  modelAndView=new ModelAndView("userhome");
		int productId = Integer.parseInt(httpServletRequest.getParameter("s"));
		int quantity = Integer.parseInt(httpServletRequest.getParameter("k"));
		Product product = productDaoImpl.getProduct(productId);
		Cart cart=cartDaoImpl.getsavetocart(product,quantity);
		modelAndView.addObject("cartlist", cart);
		return modelAndView;
	 }
	@RequestMapping("/DisplayCart")
	public ModelAndView displayCart() 
	{
		ModelAndView  modelAndView=new ModelAndView("Displaycart");
		 List<Cart> cartlist  =  cartDaoImpl.Displaycart();
		 
		 modelAndView.addObject("cartlist", cartlist);
		 return modelAndView;
	}
}
