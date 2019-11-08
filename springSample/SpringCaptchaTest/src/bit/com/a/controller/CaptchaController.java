package bit.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaptchaController {
	private static final Logger logger = LoggerFactory.getLogger(CaptchaController.class);
	
	@RequestMapping(value = "cap.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String cap() {
		
		logger.info("cap.do in" + new Date());
		
		return "Cap.tiles";
	}
	
	@PostMapping(value = "captcha")
	public String captcha(HttpSession session, @RequestParam String captcha) {
		
		logger.info("cpaCon captcha in");
		
		String capChaValue = (String) session.getAttribute("captcha");
		if(captcha == null || !capChaValue.equals(captcha)) {
			System.out.println("널이거나 같지않음 타일즈로 넘김");
			return "CaptchaFail.tiles";
		}
		System.out.println("같음");
		return "CaptchaSuc.tiles";
	}
	
}
