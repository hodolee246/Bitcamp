package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.val;

@Controller
public class ExController {

	@RequestMapping(value = "/hello")
	public String hello() {
		
		/*
		 * ModelAndView mav = new ModelAndView();
		 * 
		 * mav.setViewName("hello");
		 */
		return "hello";
		
	}
	
}
