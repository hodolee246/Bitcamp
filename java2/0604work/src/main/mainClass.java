package main;

import java.util.Scanner;

import dao.MemberDao;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// baseballMember
		int n = sc.nextInt();
		MemberDao dao = new MemberDao();
	out:while(true) {
		switch (n) {
		case 1:
			dao.insert();
			break;

		case 2:
			dao.delete();
			break;
		case 3:
			dao.select();
			break;
		case 4:	
			dao.update();
			break;
		case 5:	
			dao.allprint();
			break;
		case 6:
			dao.saveData();
			break;
		case 7:
			break out;
		}
		}
		
	}

}
