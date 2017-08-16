package com.mmtc.springboot.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.mmtc.springboot.AppConstatnts;
import com.mmtc.springboot.model.Booking;
import com.mmtc.springboot.model.User;
import com.mmtc.springboot.restclient.RestAPIAdapter;
import com.mmtc.springboot.services.BookingService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
public class BookingController {
	
	final static Logger logger = Logger.getLogger(BookingController.class);

	
	@Value("${rest_service_uri}")
	private String restUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private RestAPIAdapter restAPIAdapter;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	BookingService bookingService;
	
	@RequestMapping(value = "/addbooking", method=RequestMethod.POST)
	public String mNewBooking( 
			@RequestParam(value = "customerId") String customerId,
			@RequestParam(value = "type") String type,
			@RequestParam(value = "cost") String cost,
			@RequestParam(value = "source") String source,
			@RequestParam(value = "destination") String destination,
			final Model model) {
		try {
			
			User user  = (User) httpSession.getAttribute(AppConstatnts.LOGGEDIN_USER);
			
			ResponseEntity<List> listBookings = restTemplate.postForEntity(restUrl + "/booking/" + RestAPIAdapter.QPM_ACCESS_TOKEN + restAPIAdapter.getAccessToken(), null, List.class, new HashMap<String, String>());
		    List<Booking> bookings = listBookings.getBody();
			
			Booking newBooking = new Booking();
			newBooking.setId(bookings.size() + 1);
			newBooking.setCustomerId(customerId.toUpperCase());
			newBooking.setBookingDate(new Date());
			newBooking.setBookingType(type.toUpperCase());
			newBooking.setBookingCost(Double.parseDouble(cost));
			newBooking.setSource(source);
			newBooking.setDestination(destination);
			
			ResponseEntity<Boolean> result = restTemplate.postForEntity(restUrl + "/booking/add" + RestAPIAdapter.QPM_ACCESS_TOKEN + restAPIAdapter.getAccessToken(), newBooking, Boolean.class, new HashMap<String, String>());
			Boolean boolBooked = result.getBody();
			
			listBookings = restTemplate.postForEntity(restUrl + "/booking/" + RestAPIAdapter.QPM_ACCESS_TOKEN + restAPIAdapter.getAccessToken(), null, List.class, new HashMap<String, String>());
		    bookings = listBookings.getBody();
			
			model.addAttribute("name", user.getUserId());
			model.addAttribute("logintype", user.getUserType());
			model.addAttribute("bookings", bookings);

			return "site.bookpage";
			
		} catch (Exception e) {
			model.addAttribute("errorMsg", "invalid booking details!.");
			return "site.bookpage";
		}
			
	}
	
	
	@RequestMapping(value = "/book", method = RequestMethod.GET)
	public String mBook(final Model model) {
		
		User user  = (User) httpSession.getAttribute(AppConstatnts.LOGGEDIN_USER);
		
		Map<String, String> map = new HashMap<String, String>();
        //map.put("userId", userId);
        
        ResponseEntity<List> result = restTemplate.postForEntity(restUrl + "/booking/" + RestAPIAdapter.QPM_ACCESS_TOKEN + restAPIAdapter.getAccessToken(), null, List.class, map);
        List<Booking> bookings = result.getBody();
		
		model.addAttribute("name", user.getUserId());
		model.addAttribute("logintype", user.getUserType());
		model.addAttribute("bookings", bookings);

		return "site.bookpage";
	}
	
	
//	@RequestMapping(value = "/doNewbooking", method = RequestMethod.POST)
//	public String mGetAllBookings(final Model model) {
//		
//		User user  = (User) httpSession.getAttribute(AppConstatnts.LOGGEDIN_USER);
//		
//		Map<String, String> map = new HashMap<String, String>();
//        //map.put("userId", userId);
//        //map.put("userType", userType);
//        
//        ResponseEntity<List> result = restTemplate.postForEntity(restUrl + "/bookings/" + RestAPIAdapter.QPM_ACCESS_TOKEN + restAPIAdapter.getAccessToken(), null, List.class, map);
//        List<Booking> bookings = result.getBody();
//		
//		model.addAttribute("name", user.getUserId());
//		model.addAttribute("logintype", user.getUserType());
//		model.addAttribute("bookings", bookings);
//		
//		return "site.homepage";
//	}

}
