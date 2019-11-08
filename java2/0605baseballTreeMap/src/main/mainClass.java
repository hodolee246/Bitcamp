package main;

import dao.MemberDao;
import dto.Human;

public class mainClass {

	public static void main(String[] args) {
		
		MemberDao dao = new MemberDao();
		
		dao.insert();
		dao.allprint();
		dao.insert();
		dao.allprint();
		
		dao.delete();
		dao.allprint();
		
		
		
	}

}
