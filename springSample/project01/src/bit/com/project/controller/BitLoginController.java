package bit.com.project.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import bit.com.project.model.MemberDto;
import bit.com.project.service.BitLoginService;



@Controller
public class BitLoginController {

	private static final Logger logger = LoggerFactory.getLogger(BitLoginController.class);
	
	@Autowired
	private BitLoginService bitLoginService;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login(Model model) {
		logger.info("login " + new Date());
		
		
		return "login";	// login.jsp 로 이동해라
	}
	
	@RequestMapping(value = "account.do", method = RequestMethod.GET)
	public String account(Model model) {
		logger.info("account" + new Date());
		
		return "account";
	}
	
	@RequestMapping(value = "accountAf.do", method = RequestMethod.POST)
	public String accountAf(MemberDto dto, Model model, HttpServletRequest req)throws Exception {
		
		logger.info("BitLoginController accountAf");
		
		logger.info(dto.toString());
		
		boolean b = bitLoginService.addMember(dto);
		
		if(b) {
			logger.info("회원가입 되었습니다." + new Date());
			return "login";
		}
		return "account";
		
	}
	
}
