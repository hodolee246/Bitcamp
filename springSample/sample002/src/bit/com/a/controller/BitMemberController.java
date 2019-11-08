package bit.com.a.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import bit.com.a.service.BitMemberService;

@Controller
public class BitMemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(BitMemberController.class);
	
	@Autowired // DI : 의존성(framwork 가 자동으로 동적 할당을 해준다.)
	private BitMemberService bitMemberService;

		
}
