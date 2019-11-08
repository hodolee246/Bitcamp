package com.hello.boot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController {
	
	//@GetMapping(value = "hello")
	@RequestMapping(value = "hello")
	public String hello() {
		
		System.out.println("hello!!");
				
		return "hello";
	}
	
}
