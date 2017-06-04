package com.riktek.app.main;

//import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.riktek.app.main.AppConfig;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.riktek.controller","com.riktek.service"})
//@EnableMongoRepositories("com.riktek.repository")
@Configuration
@Import(AppConfig.class)
public class MainClass
{
	
	//private static final Logger LOGGER = Logger.getLogger(MainClass.class);

	
	public static void main(String [] args)
	{
		 SpringApplication.run(MainClass.class, args);
		
	}
	

}