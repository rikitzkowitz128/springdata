package com.riktek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;




@Controller
public class GreetingController
{
	
	
	@RequestMapping(value = "/greeting/*", method = RequestMethod.GET)
	public String renderGreetingView()
	{
		return "index";
	}
	
	
}