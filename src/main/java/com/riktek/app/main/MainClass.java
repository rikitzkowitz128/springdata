package com.riktek.app.main;

//import org.apache.log4j.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.integration.dsl.IntegrationFlow;

import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import org.springframework.integration.dsl.support.Transformers;
import org.springframework.integration.ws.WebServiceHeaders;
import org.springframework.integration.ws.SimpleWebServiceOutboundGateway;
import org.springframework.integration.xml.transformer.XPathTransformer;

import org.springframework.context.annotation.Bean;

import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.riktek.app.main.AppConfig;

//@Configuration
//@EnableAutoConfiguration
//@ComponentScan({"com.riktek.controller","com.riktek.service"})
//@EnableMongoRepositories("com.riktek.repository")
@Configuration
@IntegrationComponentScan
@Import(AppConfig.class)
public class MainClass
{
	
	//private static final Logger LOGGER = Logger.getLogger(MainClass.class);

	
	public static void main(String [] args)
	{
		 //SpringApplication.run(MainClass.class, args);
		 ConfigurableApplicationContext ctx = SpringApplication.run(MainClass.class, args);
		 //TempConverter converter = ctx.getBean(TempConverter.class);
		 //System.out.println(converter.fahrenheitToCelcius(68.0f));
		 //ctx.close();
		
	}
	
	/*
	@MessagingGateway
	public interface TempConverter 
	{
		@Gateway(requestChannel = "convert.input")
    	float fahrenheitToCelcius(float fahren);
    }

    @Bean
    public IntegrationFlow convert() 
    {
      return f -> f
        .transform(payload ->
              "<FahrenheitToCelsius xmlns=\"http://www.w3schools.com/xml/\">"
            +     "<Fahrenheit>" + payload + "</Fahrenheit>"
            + "</FahrenheitToCelsius>")
        .enrichHeaders(h -> h
            .header(WebServiceHeaders.SOAP_ACTION,
                "http://localhost:8000/spring-data-rest/scifiProfileDToes/5934730a36e8b81abc75ac82"))
        .handle(new SimpleWebServiceOutboundGateway(
            "http://localhost:8000/spring-data-rest/scifiProfileDToes/5934730a36e8b81abc75ac82"))
        .transform(Transformers.xpath("/*[local-name()=\"FahrenheitToCelsiusResponse\"]"
            + "/*[local-name()=\"FahrenheitToCelsiusResult\"]"));
    }
	*/
	

}
