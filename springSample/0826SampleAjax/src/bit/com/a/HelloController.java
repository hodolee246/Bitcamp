package bit.com.a;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.MyData;
import bit.com.a.model.myClass;

@Controller
public class HelloController {
	
	private static final Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	// 데이터 넣고 들고 넘어가기
	public String hello(Model model, HttpServletRequest http) {
		
		logger.info("helloController hello()");
		
		myClass cls = new myClass();
		cls.setNumber(1001);
		cls.setName("홍길동");
		
		model.addAttribute("cls", cls);
		
		return "hello";
		
	}
	// 데이터 받고 그걸 들고 넘어가기
	@RequestMapping(value = "inputData.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String inputData(Model model, myClass cls) {
		/* 두번째 파라메터로 myClass로 할경우 데이터를 받고나면 자동으로 cls 형태로 바꿔준다(String이 int 로 변환됨)	 */
		logger.info("HelloController inputData()" + new Date());
		
		logger.info(cls.toString() + new Date());
		
		model.addAttribute("cls", cls);
		
		return "hello";
	}
	// 3 컨트롤러 -> 컨트롤러
	@RequestMapping(value = "move.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String move() {
		logger.info("helloController move()" + new Date());
		
		// sendredirect 가 이렇게 사용된다
		return "redirect:/hello.do";
		// 만약 데이터를 들고 넘어갈경우
		// return "forward:/hello.do";	
	}
	// 4 ajax
	@ResponseBody
	@RequestMapping(value = "idcheck.do",
				// String 리턴값이 한글일 경우 사용한다.
					produces="application/String; charset=utf-8",
					method = {RequestMethod.GET, RequestMethod.GET})
	public String idcheck(String id) {
		logger.info("helloController idcheck() " + new Date());
		logger.info("id:" + id);
		
		String str = "한글";
		
		// 원래라면 return 값이 이동할 jsp 를 입력하지만 지금은 ajax 이기에
		// ajax에서 들고 나갈 리턴값인 ok 를 넘겨준다.
		return str;
	}
	// 5 ajax map 으로 넘기기
	@ResponseBody
	@RequestMapping(value = "account.do", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> account(MyData my) {
		logger.info("HelloController account() " + new Date());
		
		// 넘어온 데이터 확인
		logger.info(my.toString() + new Date());
		
		// 필요하다면 DB 접근 부분
		
		// 넘길 데이터 준비
		Map<String, Object> rmap = new HashMap<String, Object>();
		
		rmap.put("msg", "message");
		rmap.put("data", "2633");
		
		return rmap;
		
	}
	// 6 ajax 컨트롤러 에서 map 으로 받고 넘기기
	@ResponseBody
	@RequestMapping(value = "updateUser.do", method = {RequestMethod.GET, RequestMethod.POST})
									// map 으로 받을때에는 @requestBody가 필요하다
	public Map<String, Object> updateUser(@RequestBody Map<String, Object> map){
		logger.info("HelloController updateUser() " + new Date());
		
		// info 에서는 + "" 처럼 String 으로 바꿔줘야지 오류가 없어진다.
		logger.info(map.get("name") + "");	
		logger.info(map.get("phone") + "");
		logger.info(map.get("email") + "");	
		logger.info(map.get("birth") + "");
		
		Map<String, Object> rmap = new HashMap<String, Object>();
		rmap.put("msg", "데이터");
		rmap.put("data", "안녕하세요");
		
		return rmap;
		
	}
}
