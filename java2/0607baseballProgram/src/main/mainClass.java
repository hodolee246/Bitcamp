package main;

import java.util.Scanner;

import dao.DaoInterface;
import file.FileClass;
import processing.AllPrintClass;
import processing.DeleteClass;
import processing.DescendingClass;
import processing.InsertClass;
import processing.SelectClass;
import processing.UpdateClass;

public class mainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		/*
		InsertClass in = new InsertClass();
		DeleteClass del = new DeleteClass();
		SelectClass sel = new SelectClass();
		UpdateClass up = new UpdateClass();
		AllPrintClass all = new AllPrintClass();
		DaoInterface dao = new DaoInterface() {
			*/
		FileClass myfile = new FileClass();
		myfile.loadfile();
		
		DaoInterface dao;
		dao = new InsertClass();
		boolean b = true;
		while(b) {
			
			System.out.println("1. 입력");
			System.out.println("2. 삭제");
			System.out.println("3. 검색");
			System.out.println("4. 수정");
			System.out.println("5. 출력");
			System.out.println("6. 출력순서");
			System.out.println("7. 파일 저장");
			System.out.println("8. 종료");
			int n = sc.nextInt();
		
			
			switch (n) {
			case 1:
				dao.Process();
				break;
			case 2:	
				dao = new DeleteClass();
				dao.Process();
				break;
			case 3:
				dao = new SelectClass();
				dao.Process();
				break;
			case 4:
				dao = new UpdateClass();
				dao.Process();
				break;
			case 5:
				dao = new AllPrintClass();
				dao.Process();
				break;
			case 6:
				dao = new DescendingClass();
				dao.Process();
				break;
			case 7:
				dao = new FileClass();
				dao.Process();
			case 8:
				b = false;
				break;
			}
		}
	}
}
		