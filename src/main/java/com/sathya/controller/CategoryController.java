package com.sathya.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.Daoimpl.CategoryDaoImpl;
import com.sathya.Daoimpl.TestingSessionfactory;
import com.sathya.model.Category;

@Controller
public class CategoryController
{
	
	@Autowired
	 CategoryDaoImpl categoryDaoImpl;
	
	
@RequestMapping("/category")
    public ModelAndView goToCategoryForm()
    {
        ModelAndView  mv=new ModelAndView("category");
        
        
        mv.addObject("cat",new Category());
        
        mv.addObject("ButtonName","AddCategory");
        return  mv;
    }
    
    @RequestMapping(value="/addCat",method=RequestMethod.POST)
    public ModelAndView recieveCategoryFormData(@ModelAttribute ("cat") Category ca)
    {
    	ModelAndView  mv=new ModelAndView("home");
        System.out.println(ca.getCategoryName());
        System.out.println(ca.getCategoryDiscription());
      categoryDaoImpl.CategoryDao(ca);
     // mv.addObject("ButtonName","AddCategory");
        return mv;
    }
    @RequestMapping("ShowCat")
    public ModelAndView RetrieveAllCategoryData()
    {
   List<Category> categoriesList=categoryDaoImpl.getCategoryData();
        ModelAndView  modelAndView=new ModelAndView("Showcategory");
        
        modelAndView.addObject("catlist", categoriesList);
        
        
        return modelAndView  ;
    }
    
    @RequestMapping("/del")
    public String DeleteCategoryData(@RequestParam("catId") int categoryId)
    {
    	
    	
    	Category category= categoryDaoImpl.getCategory(categoryId);
    	categoryDaoImpl.delCategoryData(category);
         
        
        
        return "redirect:ShowCat";
    }
    @RequestMapping("/edit")
    public ModelAndView EditCategoryData(@RequestParam("catId") int categoryId)
    {
    	Category category= categoryDaoImpl.getCategory(categoryId);
    	categoryDaoImpl.editCategoryData(category);
    	System.out.println("hello"+category.getCategoryName());
   ModelAndView  modelAndView=new ModelAndView("category");
        
        modelAndView.addObject("cat", category);
        
        modelAndView.addObject("ButtonName","UpdateCategory");
        return modelAndView  ;
    }
    /*  
    @RequestMapping("/del")
    public ModelAndView DeleteCategoryData(@RequestParam("catId") int categoryId)
    {
    	ModelAndView  modelAndView=new ModelAndView("Showcategory");
    	categoryDaoImpl.delteCategoryData(categoryId);
    List<Category> categorylist=categoryDaoImpl.getCategoryData();
    modelAndView.addObject("catlist", categorylist);
      return modelAndView;  
    }*/
}