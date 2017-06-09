package com.example.demo.ctrls;

import java.util.Date;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@RequestMapping(value = "/msg", method = RequestMethod.GET)
	public String getMessage() {
		return "Welcome : Today-" + new Date().toString();
	}

}
