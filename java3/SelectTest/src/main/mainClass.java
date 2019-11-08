package main;

import java.util.List;

import db.DBConnection;
import dto.UserDto;
import select.SelectTest;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();
		
		SelectTest st = new SelectTest();
		
		UserDto ud = st.Search("bbb");
		
		if(ud != null) {
			System.out.println(ud.toString());
		}else {
			System.out.println("데이터를 찾을 수 없습니다.");
		}

		ud = st.search2("bbb");
		if( ud != null) {
			System.out.println(ud.toString());
		}else {
			System.out.println("데이터를 찾을 수 없습니다.");
		}
		
		List<UserDto> userlist = st.getUserList();
		
		for (UserDto user : userlist) {
			System.out.println(user.toString());
		}
		
		
		
		
		
	}

}
