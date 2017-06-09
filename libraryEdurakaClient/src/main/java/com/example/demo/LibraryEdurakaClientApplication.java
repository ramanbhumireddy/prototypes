package com.example.demo;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

@SpringBootApplication
public class LibraryEdurakaClientApplication {

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx = SpringApplication.run(LibraryEdurakaClientApplication.class, args);
		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
		System.out.println(consumerControllerClient);
		
		try {
			consumerControllerClient.doTestService();
		} catch (Exception e) {
			System.out.println("do test failed.");
		}
		
		try {
			consumerControllerClient.viewBooks();
		} catch (Exception e) {
			System.out.println("viewBooks failed.");
		}
	}
	
	@Bean
	public  ConsumerControllerClient  consumerControllerClient(){
		return  new ConsumerControllerClient();
	}
}
