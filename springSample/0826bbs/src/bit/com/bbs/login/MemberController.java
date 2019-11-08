package bit.com.bbs.login;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import bit.com.bbs.model.MemberDto;
import bit.com.bbs.service.MemberService;

@RestController
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "loginPage.do", method = RequestMethod.GET)
	public String login(ModelAndView mav) {
		
		logger.info("MemberController login() " + new Date());
		
		mav.setViewName("member/login");
		
		return "member/login";		
	}
	
	@RequestMapping(value = "accountPage.do", method = RequestMethod.GET)
	public String accountPage() {
		logger.info("accountPage()" + new Date());
		
		return "member/account";
	}
	
	@ResponseBody
	@RequestMapping(value = "idcheck.do",
	produces="application/String; charset=UTF-8",
	method = RequestMethod.GET)
	public String idcheck(String id) {
		logger.info("idcheck()" + new Date());
		
		int n = memberService.idCheck(id);
		
		if(n>0) {
			return "사용불가한 아이디 입니다.";
		}else {
			return "사용가능한 아이디 입니다.";
		}
		
	}
	
	@RequestMapping(value = "account.do", method = RequestMethod.GET)
	public String account(MemberDto mem) {
		logger.info("account()" + new Date());
		
		logger.info(mem.toString() + new Date());
		
		boolean b = memberService.addMember(mem);
		
		if(b) {
			return "member/login";
		}else {
			return "member/account";
		}
	}
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login(MemberDto mem, HttpServletRequest req) {
		
		logger.info("login() " + new Date());
		
		
		boolean b = memberService.login(mem);

		if(b) {
			
			req.getSession().setAttribute("login", mem);
			req.getSession().setMaxInactiveInterval(10);
			
			return "redirect:/loginSuc.do";
		}else {
			return "member/login.do";
		}
		
	}
	
}
