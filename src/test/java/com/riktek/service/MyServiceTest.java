package com.riktek.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.riktek.main.AppConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class MyServiceTest
{
	
	@Autowired
	private MyService myService;
	
	@Before 
	public void setUp()
	{
	}
	
	@Test
	public void message_ShouldReturnMessageTest()
	{
		assertEquals("Goodbye Texas, Hello California!",myService.getMessage());
	}
	
	
	
}