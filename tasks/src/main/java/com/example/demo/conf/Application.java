package com.mmtc.springboot;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan 
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

	final static Logger logger = Logger.getLogger(Application.class);
	
    public static void main(String[] args) {
       ConfigurableApplicationContext conAppContext= SpringApplication.run(Application.class, args);
       if(null != conAppContext){
    	   logger.info("AppContextStarted.");
    	   //servletContext
       }
    }
    
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	servletContext.addListener(sessionListener());
    	logger.info("Add SessionListener.");
    	super.onStartup(servletContext);
    }
    
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
    
	
	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	
	@Bean
	public SessionListener sessionListener(){
		return new SessionListener();
	}
	
}
