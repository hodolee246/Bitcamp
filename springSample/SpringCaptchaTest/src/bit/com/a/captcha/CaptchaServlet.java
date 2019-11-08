package bit.com.a.captcha;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.captcha.Captcha;
import nl.captcha.servlet.CaptchaServletUtil;

public class CaptchaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Captcha captcha = new Captcha.Builder(148, 48)
					.addText()	// defalut: 5개의 숫자와 문자로 이루어져있다.
					.addNoise().addNoise().addNoise()	// add noise 하나당 방해선 하나가 추가된다.
					.addBackground()	// 기본 하얀색 배경
					.build();
		
		
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0);
		resp.setHeader("Pragma", "no-cache");
		resp.setDateHeader("Max-Age", 0);
		resp.setContentType("image/png");
        CaptchaServletUtil.writeImage(resp, captcha.getImage()); // 이미지 그리기
        req.getSession().setAttribute("captcha", captcha.getAnswer()); // 값 저장

	}

	
	
}
