package com.example.demo;

import static org.junit.Assert.*;

import java.net.URI;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LibraryApplicationTests {

	private String strUri = "http://localhost:8080";
	private String defaultHandler = "/getUser";
    @Autowired
    private TestRestTemplate restTemplate;
	
	@Test
	public void contextLoads() {
//		assertNotNull(restTemplate);
	}
//	
//	@Test
//	public void testGetEmployee() throws Exception {
//		URI uri = URI.create(strUri + defaultHandler);
//		ResponseEntity<String> responseEntity =   restTemplate.getForEntity(uri, String.class); 
//	 
//		// collect response
//		int status = responseEntity.getStatusCodeValue();
//		String resultEmployee = responseEntity.getBody();
//	 
//		// verify
//		assertEquals("Incorrect Response Status", HttpStatus.SC_OK, status);
//	 
//		assertNotNull(resultEmployee);
//		//assertEquals(1l, resultEmployee.getId().longValue());
//	 
//	}
	
	
}
