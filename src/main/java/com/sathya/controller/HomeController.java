package com.sathya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
@RequestMapping("/homecontoller")
public String goHome()
{
	return "home";
}
@RequestMapping("/Aboutus")
public String goAboutUs()
{
	return "AboutUs";
}
@RequestMapping("/Contactus")
public String goContactUs()
{
	return "ContactUs";
}
@RequestMapping("/userhome")
public String goUserHome()
{
	return "userhome";
}
@RequestMapping("/userAboutus")
public String gouserAboutUs()
{
	return "AboutUs";
}
@RequestMapping("/userContactus")
public String gouserContactUs()
{
	return "ContactUs";
}

}
