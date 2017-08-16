package com.produce;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produce.ctrls.UserController;

@RestController
@ComponentScan(basePackages={"com.produce"})
@SpringBootApplication
public class ApplicationMain extends SpringBootServletInitializer{

	
	final static Logger logger = Logger.getLogger(UserController.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ApplicationMain.class);
	}
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	public static void main(String[] args) {
		ConfigurableApplicationContext appContext =  SpringApplication.run(ApplicationMain.class, args);
		if( null != appContext)
			logger.info("produce application-context ready.");
	}

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="MMTC") String name) {
    	logger.debug("/greeting");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
	
}
