package com.hello.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecContr {

	@GetMapping( value = "/")
	public String goIndex() {
		
		return "index";
	}
}
