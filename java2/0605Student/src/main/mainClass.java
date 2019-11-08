package main;

import java.util.Scanner;

import dao.DaoClass;
import dto.DtoStudent;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		DaoClass dao = new DaoClass();
		
	while(true) {
			System.out.println("1. 학생정보 입력");
			System.out.println("2. 학생정보 삭제");
			System.out.println("3. 학생정보 검색");
			System.out.println("4. 학생정보 수정");
			System.out.println("5. 학생정보 출력");
			System.out.println("6. 종료");
			int n = sc.nextInt();
			
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
				dao.updata();
				break;
			case 5:
				dao.allprint();

			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}









