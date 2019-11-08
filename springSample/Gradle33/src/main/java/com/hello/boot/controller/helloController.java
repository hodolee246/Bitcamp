package com.hello.boot.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) 
public class helloController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWolrd(Model model) {
		
		model.addAttribute("hi", "hello Wolrd");
		
		return "index";
	}
	
}
