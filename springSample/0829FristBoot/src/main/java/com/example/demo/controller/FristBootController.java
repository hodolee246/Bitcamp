package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FristBootController {
	
	@GetMapping(value = "frist")
	public String hello() {
		
		
		return "hello";
		
	}
	
}
