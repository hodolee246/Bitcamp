package bit.com.a.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
@Aspect
public class logAop {
	@Around("within(bit.com.a.controller.*) or within(bit.com.a.dao.impl.*)")
	public Object loggerAop(ProceedingJoinPoint joinpoint)throws Throwable {
		
		String signatureStr = joinpoint.getSignature().toShortString();
		
		try {
			System.out.println("loggerAOP:" + signatureStr + "메소드가 실행되었습니다.");
			// 실행 전 처리
			Object obj = joinpoint.proceed();	// 메소드가 실행
			return obj;
		}finally {
			// 실행 후 처리
		}
	}
}
