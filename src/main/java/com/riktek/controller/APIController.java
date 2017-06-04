package com.riktek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.PathVariable;


import com.riktek.service.MyService;

import com.riktek.controller.dto.ScifiProfileRESTDTO;

import java.util.List;
import javax.validation.Valid;


@RestController
@RequestMapping(value = "/api/profile")
final public class APIController
{
	@Autowired
	private MyService myService;
	
	
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    ScifiProfileRESTDTO create(@RequestBody @Valid ScifiProfileRESTDTO profile) 
    {
        return myService.create(profile);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    ScifiProfileRESTDTO delete(@PathVariable("id") String id) 
    {
        return myService.delete(id);
    }
 
    @RequestMapping(method = RequestMethod.GET)
    List<ScifiProfileRESTDTO> findAll()
    {
    	//System.out.println("findAll");
        return myService.findAll();
    }
    
    @RequestMapping(value = "{gt}/{lt}",method = RequestMethod.GET)
    List<ScifiProfileRESTDTO> findBetweenAges(@PathVariable("gt") int gt,@PathVariable("lt") int lt)
    {
    	//System.out.println("findAll");
        return myService.findProfileBetweenAges(gt, lt);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    ScifiProfileRESTDTO findById(@PathVariable("id") String id) 
    {
    	//System.out.println("findById");
        return myService.findById(id);
    }
 
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    ScifiProfileRESTDTO update(@RequestBody @Valid ScifiProfileRESTDTO profile) 
    {
        return myService.update(profile);
    }
 
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void handleTodoNotFound(Exception ex) 
    {
    }
	
}