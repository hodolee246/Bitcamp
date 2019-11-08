package main;

import db.jdbcTest;
import dto.UserDto;

public class mainClass {

	public static void main(String[] args) {
		/*
		 
		  JDBC
		  Java DataBase Connectivity    // 자바와 데이터베이스를 건넥트(연결) 할 수 있도록 만든것
		 */

		jdbcTest jt = new jdbcTest();

		UserDto dto = new UserDto("aaa", "홍길동", 24, "");
		
		int n = jt.Delete("홍길동");
		if(n > 0) {
			System.out.println("정상적으로 삭제 되었습니다.");
		}
	}

}
