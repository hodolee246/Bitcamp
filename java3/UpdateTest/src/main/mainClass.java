package main;

import db.DBConnection;
import dto.UserDto;
import up.UpdateTest;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
		UpdateTest ut = new UpdateTest();
		
		String id = "bbb";
		int age = 25;
		
		boolean b = ut.update(id, age);
		
		if(b) {
			System.out.println("성공적으로 수정했습니다.");
		}
		else {
			System.out.println("수정을 실패했습니다.");
		}
		}
	}


