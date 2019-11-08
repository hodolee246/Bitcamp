package com.aopex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class mainClass {

	public static void main(String[] args) {

		// java에서 xml 실행시 
		AbstractApplicationContext ctx 
			= new GenericXmlApplicationContext("bean.xml");
		
		// bean.xml 에서 생성된 객체를 취득하기
		CatDto mycat = ctx.getBean("myCat", CatDto.class);
		// mycat 객체가 동작을 할때마다 aop가 잡아낸다.
		mycat.catInfo();
		mycat.getName();
		
		// 다른 객체라 취급을해서 aop 가 작동을 안함
		CatDto youCat = new CatDto("고양이", 2, "분홍");
		youCat.catInfo();
		
	}

}
