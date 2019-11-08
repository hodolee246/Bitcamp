package main;

import java.util.Scanner;

import dao.MemberDao;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MemberDao md = new MemberDao();
	out:while(true) {
			
			System.out.println("어느 작업을 하시겠습니까?");
			System.out.println("1. 선수 등록");
			System.out.println("2. 선수 삭제");
			System.out.println("3. 선수 검색");
			System.out.println("4. 선수 수정");
			System.out.println("5. 선수 명단 모두 출력");
			System.out.println("6. 종료");
			int no = sc.nextInt();
			
			switch (no) {
			case 1:
				md.insert();
				break;
			case 2:
				md.delete();
				break;
			case 3:
				md.select();
				break;
			case 4:
				md.update();
				break;
			case 5:
				md.allprint();
				break;
			case 6:
				break out;
			
			}
		}

	}

}
