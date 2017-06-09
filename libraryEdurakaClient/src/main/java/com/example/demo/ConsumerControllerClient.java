package com.example.demo;


import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ConsumerControllerClient {

	//String baseUrl = "http://localhost:8080/testHandler";
			//String baseUrl = "http://10.109.89.17:8080/testHandler";
		
	private String baseUrl = "http://10.109.89.17:8080/";
	private String libraryUsersBaseUrl = "http://10.109.89.17:8080/lus";
	private String libraryAdminBaseUrl = "http://10.109.89.17:8080/las";

	
	public void doTestService() throws RestClientException, IOException {
		String auth = "raman" + ":" + "raman";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
			response=restTemplate.exchange(baseUrl + "testHandler", HttpMethod.GET, getHeaders(auth), String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
	}
	
	public void viewBooks() throws RestClientException, IOException {
		String auth = "raman" + ":" + "raman";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
			response=restTemplate.exchange(libraryUsersBaseUrl + "/viewBooks", HttpMethod.GET, getHeaders(auth), String.class);
		}
		catch (Exception ex){
			System.out.println(ex);
		}
		System.out.println(response.getBody());
	}

	private static HttpEntity<?> getHeaders(String argCredentials) throws IOException {
		HttpHeaders headers = new HttpHeaders();
		String auth = "raman" + ":" + "raman";
        byte[] encodedAuth = Base64.encode(auth.getBytes(Charset.forName("US-ASCII")));
        String authHeader = "Basic " + new String( encodedAuth );
		headers.set("Authorization", authHeader );
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}
}