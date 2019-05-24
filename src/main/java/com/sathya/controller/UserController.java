package com.sathya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sathya.Daoimpl.UserDaoImpl;
import com.sathya.model.User;

@Controller
public class UserController
{
@Autowired
UserDaoImpl userDaoImpl;
@RequestMapping("/register")
public ModelAndView gotoresgesterform()
{
	ModelAndView  modelAndView=new ModelAndView("Register");
	modelAndView.addObject("reg",new User());
	return modelAndView;
}
@RequestMapping(value="/register",method=RequestMethod.POST)
public ModelAndView reciveuserformdata(@ModelAttribute("reg") User user)
{
	ModelAndView  modelAndView=new ModelAndView("userhome");
	userDaoImpl.gotoresgesterformDao(user);
	return modelAndView; 
}
@RequestMapping("/LOGIN")
public ModelAndView responcetologin()
{

ModelAndView  modelAndView=new ModelAndView("Login");
modelAndView.addObject("reg",new User());
return modelAndView;

}
@RequestMapping(value="/loginsuc",method=RequestMethod.POST)
public ModelAndView reciveloginformdata(@ModelAttribute("reg") User user)
{

	boolean result=userDaoImpl.loginvalidation(user);
	if(result==true)
	{
		ModelAndView  modelAndView=new ModelAndView("Loginsucess");	
		return modelAndView;
	}
	else
	{
		ModelAndView  modelAndView=new ModelAndView("Login");
		modelAndView.addObject("loginfo" ,"worngemail/password");
		return modelAndView;	
	}
	
}
}
	