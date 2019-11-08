package com.hello.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NaverController {

	@GetMapping("/nealo")
	public String naverLogin() {
		
		return "nealo";
	}
	
	
	
}
