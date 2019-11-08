package bit.com.bbs.aop;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import bit.com.bbs.model.MemberDto;

// 감시자
@Aspect
public class logAop {
	
		@Around("within(bit.com.bbs.controller.*)")
		public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
			
			StopWatch stopWatch = new StopWatch();
			stopWatch.start();
			
			System.out.println(joinpoint.getSignature().toShortString() + "시작");
			HttpServletRequest req = 
					((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
			
			
			if(req != null) {
				HttpSession session = req.getSession();
				
				MemberDto mem = (MemberDto)session.getAttribute("login");
				
				if(mem == null) {
					System.out.println("비어있습니다.");
					return "redirect:/loginPage.do";
					
				}
				}else {
					System.out.println("id 있음");
			
			
			}	

			Object obj = joinpoint.proceed();
			stopWatch.stop();
			
			System.out.println(joinpoint.getSignature().toShortString() + "메소드가 실행되었습니다." + stopWatch.getTotalTimeMillis());
			
			return obj;
			
		}
}		
