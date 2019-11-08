package com.aopex;

import org.aspectj.lang.ProceedingJoinPoint;

// 감시자
public class logAOP {

		public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable{
		
			String signatureStr = joinpoint.getSignature().toShortString();
		
			System.out.println(signatureStr + "시작");
			try {
				Object obj = joinpoint.proceed();		// 특정 함수가, (기능 함수) 가 실행 되었을 경우
				return obj;
			}finally {
				System.out.println("실행 후:" + System.currentTimeMillis());
				System.out.println(signatureStr + " 종료 ");
			}
		}
}
