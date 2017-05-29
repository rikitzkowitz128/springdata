package com.riktek.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.riktek.domain.DataEntity;

import com.riktek.repository.MyRepository;

@Service
public class MyService
{
	@Autowired
	private MyRepository repository;
	
	public void printMessage()
	{
		System.out.println("Goodbye Texas, Hello California!");
	}
	
	public String getMessage()
	{
		return("Goodbye Texas, Hello California!");
	}
	
	public void resetData()
	{
		clean();
	}
	
	public void seedData()
	{
		seed();
	}
	
	private void clean()
	{
		repository.deleteAll();
	}
	
	private void seed()
	{
		repository.save(new DataEntity(1, "Vorlon"));
		repository.save(new DataEntity(1, "Minbari"));
	}
}