package com.sathya.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.Daoimpl.CategoryDaoImpl;
import com.sathya.Daoimpl.ProductDaoImpl;
import com.sathya.Daoimpl.SupplierDaoImpl;
import com.sathya.model.Category;
import com.sathya.model.Product;
import com.sathya.model.Supplier;

@Controller
public class ProductController 
{
	@Autowired
	ProductDaoImpl productDaoImpl;
	@Autowired
	 CategoryDaoImpl categoryDaoImpl;
	@Autowired
	SupplierDaoImpl supplierDaoImpl;
	
	
	@RequestMapping("AddProduct")
	public ModelAndView gotoproductform()
	{
	List<Category> categorylist=categoryDaoImpl.getCategoryData();
List<Supplier> supplierlist=	supplierDaoImpl.getSupplierDaoRetriveData();
		ModelAndView modelAndView = new ModelAndView("AddProduct");
		
		modelAndView.addObject("ButtonName","AddProduct");
		modelAndView.addObject("catlist" ,categorylist);
		modelAndView.addObject("suplist", supplierlist);
		Product product=new Product();
		int id=(int)(Math.random()*10000);
		product.setProductId(id);
		modelAndView.addObject("pro", product);
		return modelAndView;
	}
	@RequestMapping(value="/addpro",method=RequestMethod.POST)
	public ModelAndView recieveCategoryFormData(@ModelAttribute("pro") Product product)
    {
		ModelAndView  modelAndView=new ModelAndView("home");
		categoryDaoImpl.getCategoryData();
		productDaoImpl.productDao(product);
		MultipartFile imag =product.getProimg();
		System.out.println("testing image="+imag);
		try {
			FileOutputStream fileOutputStream=new FileOutputStream("E:\\eclipse-workspace\\eshop\\src\\main\\webapp\\resources\\product-images\\"+product.getProductId()+".jpg");
			BufferedOutputStream bufferedOutputStream= new BufferedOutputStream(fileOutputStream);
byte bytearray[]=imag.getBytes();
bufferedOutputStream.write(bytearray);

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
//		finally
//		{
//			FilterOutputStream bufferedOutputStream = null;
//			try {
//				bufferedOutputStream .close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}	
//		}
		return modelAndView;
		
    }
	@RequestMapping("/ShowProduct")
	public ModelAndView reciveAllproductData()
	{
	List<Product> productlist=productDaoImpl.getproductData();
		ModelAndView  modelAndView=new ModelAndView("ShowProduct");
		modelAndView.addObject("prolist",productlist);
		return modelAndView;
	}
	 @RequestMapping("/pdel")
	    public String DeleteCategoryData(@RequestParam("proId") int productId)
	    {
	  Product product = productDaoImpl.getProduct(productId);
	  productDaoImpl.delProductData(product);
	File file= new File("E:\\eclipse-workspace\\eshop\\src\\main\\webapp\\resources\\product-images\\"+product.getProductId()+".jpg"); 
	  file.delete(); 
	    return "redirect:ShowProduct";
	    }
	 @RequestMapping("/pedit")
	 public ModelAndView editCategoryData(@RequestParam("proId") int productId)
	 {
		 Product product = productDaoImpl.getProduct(productId);
		 productDaoImpl.editCategoryData(product);
		 ModelAndView  modelAndView=new ModelAndView("AddProduct");
		 modelAndView.addObject("pro", product);
		 modelAndView.addObject("ButtonName","UpdateProduct");
		 List<Category> categorylist=categoryDaoImpl.getCategoryData();
		 List<Supplier> supplierlist=	supplierDaoImpl.getSupplierDaoRetriveData();
		 modelAndView.addObject("catlist" ,categorylist);
		modelAndView.addObject("suplist", supplierlist);
		 return modelAndView ;
	 }
	                              /*usermodule*/
	 @RequestMapping("/user")
	 public ModelAndView userproductData()
		{
		List<Product> productlist=productDaoImpl.getproductData();
			ModelAndView  modelAndView=new ModelAndView("userproducts");
			modelAndView.addObject("prolist",productlist);
			return modelAndView;
		}
	 @RequestMapping("viewdetails")
	 public ModelAndView productDetails(@RequestParam("proId") int productId)
		{
		
		Product product = productDaoImpl.getProduct(productId);
		ModelAndView  modelAndView=new ModelAndView("oneproduct");
			modelAndView.addObject("prolist",product);
			return modelAndView;
}
}
