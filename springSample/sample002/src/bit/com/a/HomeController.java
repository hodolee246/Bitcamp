package bit.com.a;

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
	
	@RequestMapping("/home.do")
	public ModelAndView home() {
		
		// System.out.println("HomeController home()");
		logger.info("HomeController home " + new Date());
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/home");	// home.jsp 로 이동해라
		
		return view;
	}
	
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String Hello(Model model) {
		logger.info("HomeController hello " + new Date());
		
		model.addAttribute("name", "전인우"); 	// request.setAttribute
		
		return "hello";	// hello.jsp 로 이동해라
	}
	
}
