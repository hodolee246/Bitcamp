package com.hello.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hello.boot.model.MemberDto;

@Controller
public class ThymeleafController {
	
	@RequestMapping(value = "/index")
	public String hello() {
		return "index";
	}
	
	
	  @RequestMapping(value = "login")
	  public String login(Model model) {
	  
		  MemberDto dto = new MemberDto("abc123", "1234");
		  
		  model.addAttribute("dto", dto);
		  model.addAttribute("id", "abab1123");
			 		  
	  return "login/login"; 
	  
	  }
	 
	
}
