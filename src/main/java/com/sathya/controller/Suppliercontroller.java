package com.sathya.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.Daoimpl.SupplierDaoImpl;
import com.sathya.model.Supplier;

@Controller
public class Suppliercontroller
{
	@Autowired
	SupplierDaoImpl SupplierDaoImpl;
	
@RequestMapping("/Supplier")
public ModelAndView goToSupplierform()
	{
	System.out.println("at supplier");
ModelAndView  mv=new ModelAndView("Supplier");
        
        mv.addObject("sup",new Supplier());
        mv.addObject("ButtonName","AddSupplier");
        
        return  mv;
	}

	@RequestMapping(value="/addsup",method=RequestMethod.POST)
	public ModelAndView recieveSupplierFormData(@ModelAttribute("sup") Supplier su)
	{
		ModelAndView  mv=new ModelAndView("home");
	    System.out.println(su.getSupplierName());
		System.out.println(su.getSupplierDetails());
		SupplierDaoImpl.supplierDaoAddData(su);
		return mv;
	}
	@RequestMapping("/ShowSupplierDetails")
	public ModelAndView retrieveAllSupplierData()
	{
List<Supplier> supplierlist = SupplierDaoImpl.getSupplierDaoRetriveData();
ModelAndView modelAndView  =new ModelAndView("ShowSupplier");
modelAndView.addObject("suplist", supplierlist);
        return modelAndView   ;
	}
	@RequestMapping("/sdel")
	
	public String deleteCategoryData(@RequestParam("supId")int supplierId)
	{
	Supplier supplier=SupplierDaoImpl.getsupplier(supplierId);
	SupplierDaoImpl.deletaSupplierData(supplier);

        return "redirect:ShowSupplierDetails"   ;
	
} 
	@RequestMapping("/sedit")
	public ModelAndView editCategoryData(@RequestParam("supId")int supplierId)
	{
	Supplier supplier=	SupplierDaoImpl.getsupplier(supplierId);
	SupplierDaoImpl.editSupplierData(supplier);
ModelAndView modelAndView  =new ModelAndView("Supplier");
modelAndView.addObject("sup", supplier);
modelAndView.addObject("ButtonName","UpdateSupplier");
        return modelAndView;
	
}
}