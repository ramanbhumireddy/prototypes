package com.gsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainCtrl {

	private final CounterService counterService;
	
	@Autowired
    public MainCtrl(CounterService counterService){
        this.counterService = counterService;
    }

	@RequestMapping("/")
	public ModelAndView home(){
		
        counterService.increment("counter.services.greeting.invoked");
		
		return new ModelAndView("views/home");
	}
	
}
