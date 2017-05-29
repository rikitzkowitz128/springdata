package com.riktek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.riktek.service.MyService;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CleanController
{
	@Autowired
	MyService myService;
	
	@RequestMapping(value = "/clean/*", method = RequestMethod.GET)
	public String renderCleanView()
	{
		myService.resetData();
		return "index";
	}
	
	@RequestMapping(value = "/seed/*", method = RequestMethod.GET)
	public String renderSeedView()
	{
		myService.seedData();
		return "index";
	}
	
	
	
	
	
}