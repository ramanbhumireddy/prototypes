package com.example.demo.ctrls;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCtrl {
	
	@GetMapping("/testHandler")
	public String doTest(){
		return "this is test service response.";
	}

}
