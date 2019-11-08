package bit.com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public ModelAndView home() {
		System.out.println("test 클래스 home()들어옴");
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/home");
		
		return view;
	}
}
