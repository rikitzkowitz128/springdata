package com.riktek.app.main;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.riktek.controller","com.riktek.service"})
@EnableMongoRepositories("com.riktek.repository")
public class AppConfig 
{
}