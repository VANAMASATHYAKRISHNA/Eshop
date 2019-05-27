package com.sathya.controller;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("/Registration")
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
//-------------------Spring Security-----------------------------//
@RequestMapping(value="/loginerror")
public ModelAndView afterloginfail()
{
	ModelAndView  modelAndView=new ModelAndView("Login");
	modelAndView.addObject("reg",new User());
	modelAndView.addObject("loginfo" ,"worngemail/password"); 
	return modelAndView;
}
@RequestMapping(value="/AfterLoginsucess")
public String afterLoginsucess()
{
	String pagename="";
SecurityContext securityContext = SecurityContextHolder.getContext();
 Authentication authentication  = securityContext.getAuthentication();
     String nm=      authentication.getName();
     Collection<GrantedAuthority> grantedAuthorities=(Collection<GrantedAuthority>)authentication.getAuthorities();
for (GrantedAuthority grantedAuthority : grantedAuthorities) 
 {
    String authority= grantedAuthority.getAuthority();
     if(authority.equals("ROLE-USER"))
    {
    pagename="userhome";
    return pagename;
    }
    else if(authority.equals("ROLE-ADMIN"))
    {
    	pagename="home";
        return pagename;	
    }
    	 
}
 return pagename;
}
}
	