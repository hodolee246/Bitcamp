package bit.com.project;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// @Component spring framwork 가 자동적으로 만들어준다.

// enotation으로 컨트롤러 라고 지정을 해준거다.
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/login.do")
	public ModelAndView login() {
		
		// System.out.println("HomeController login()");
		logger.info("HomeController login " + new Date());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/login");	// home.jsp 로 이동해라
		
		return view;
	}
	
	@RequestMapping(value = "account.do", method = RequestMethod.GET)
	public String Hello(Model model) {
		logger.info("HomeController account " + new Date());
		
		
		return "account";	// hello.jsp 로 이동해라
	}
	
}
