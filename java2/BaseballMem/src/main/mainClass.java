package main;

import java.util.Scanner;

import dao.MemberDao;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		MemberDao dao = new MemberDao(20);
		
		while(true) {
			
			int choice = -1;			
			System.out.println("어느 작업을 하시겠습니까?");
			System.out.println("1. 선수 등록");
			System.out.println("2. 선수 삭제");
			System.out.println("3. 선수 검색");
			System.out.println("4. 선수 수정");
			System.out.println("5. 선수 명단 모두 출력");
			System.out.println("6. 선수 명단 저장");
			System.out.println("7. 종료");
			
			System.out.print(">>");
			choice = sc.nextInt();
			
			switch (choice) {
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
				default:
					break;
			}
		}
		

	}

}




