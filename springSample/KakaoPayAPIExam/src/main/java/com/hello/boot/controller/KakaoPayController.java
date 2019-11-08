package com.hello.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hello.boot.kakao.KakaoPay;

import lombok.Setter;
import lombok.extern.java.Log;

@Log
@Controller
public class KakaoPayController {

	@Setter(onMethod_ = @Autowired)
	private KakaoPay kakaopay;
	
	@GetMapping("/kakaoPay")
	public void kakaoPayGet() {
		log.info("kakaoPay get ");
	}
	
	@PostMapping("/kakaoPay")
	public String kakaoPay() {
		
		log.info("kakaopay post");
		
		return "redirect:" + kakaopay.kakaoPayReady();
	}
	
	@GetMapping("/kakaoPaySuccess")
	public void kakaoPaySuccess(@RequestParam("pg_token") String pg_token, Model model) {
		log.info("kapay Suc get");
		log.info("kapaySuc pg_token : " + pg_token);
		
		model.addAttribute("info", kakaopay.kakaoPayInfo(pg_token));
		System.out.println("=====================================================================");
		System.out.println(kakaopay.kakaoPayInfo(pg_token));
	
	}
	
}
