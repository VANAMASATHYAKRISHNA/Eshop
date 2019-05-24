package com.sathya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class c1
{
	
	@RequestMapping("/abc")
	ModelAndView m2()
	{
		ModelAndView modelAndView=new ModelAndView("hello");
		modelAndView.addObject("nm",120);
	return modelAndView;
	}

}
