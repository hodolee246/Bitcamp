package dao;

import java.util.ArrayList;
import java.util.Scanner;

import dto.DtoStudent;
import single.Singleton;

public class DaoClass {
	Scanner sc = new Scanner(System.in);

	private int value;
	private int stunum = 1;
	ArrayList<DtoStudent> dsa = new ArrayList<DtoStudent>();

	// 추가
	public void insert() {

		int kor, eng, math;
		kor = eng = math = 0;
		String name = null;

		System.out.println("이름 입력");
		name = sc.next();

		System.out.println("국어 입력");
		kor = sc.nextInt();

		System.out.println("영어 입력");
		eng = sc.nextInt();

		System.out.println("수학 입력");
		math = sc.nextInt();
		DtoStudent ds = new DtoStudent(stunum, name, kor, eng, math);
		Singleton sc = Singleton.getInstance();
		
		sc.dsa.add(ds);

		stunum++;
		
	}

	// 삭제
	public void delete() {
		Singleton st = Singleton.getInstance();
		
		System.out.println("삭제할 번호 입력");
		int delnum = sc.nextInt();
		for (int i = 0; i < st.dsa.size(); i++) {
			DtoStudent dto = st.dsa.get(i);
			if(dto.getNumber() == delnum) {
				dsa.remove(i);
				return;
			} 
			
		}
		System.out.println("해당 번호가 없습니다.");
	}

	// 탐색(서치)
	/*
	 * public int search(int no) {
	 * 
	 * int findindex = -1 ; for (int i = 0; i < dsa.size(); i++) {
	 * 
	 * DtoStudent dto = dsa.get(i); if(dto != null && dto.getNumber() != 0) {
	 * 
	 * if(no == dto.getNumber()) { findindex = i; break; } } } return findindex; }
	 */
	// 검색(셀렉트)
	public void select() {
		Singleton st = Singleton.getInstance();
		
		System.out.println("검색할 번호 입력");
		int selnum = sc.nextInt();
		for (int i = 0; i < st.dsa.size(); i++) {
			DtoStudent dto = st.dsa.get(i);
			if(dto.getNumber() == selnum) {
				System.out.println(dto.toString());
				return;
			} 
			
		}
		System.out.println("해당 번호가 없습니다.");
	
	
	}
	// 수정
	public void updata() {
		Singleton st = Singleton.getInstance();
		System.out.println("수정할 번호 입력");
		
		int num = sc.nextInt();
		
		for (int i = 0; i < st.dsa.size(); i++) {
			DtoStudent dto = st.dsa.get(i);
			if(dto.getNumber() == num) {
				System.out.println("이름 입력");
				String name = sc.next();
				System.out.println("국어점수 입력");
				int kor = sc.nextInt();
				System.out.println("영어점수 입력");
				int eng = sc.nextInt();
				System.out.println("수학점수 입력");
				int math = sc.nextInt();
				DtoStudent dto2 = new DtoStudent(num, name, kor, eng, math);
				st.dsa.set(i, dto2);
				return;
			} 
				
			
		}
		System.out.println("해당 번호가 없습니다.");
		
	}
	// 전부출략
	public void allprint() {
		Singleton st = Singleton.getInstance();
		for (int i = 0; i < st.dsa.size(); i++) {
			
			DtoStudent d = st.dsa.get(i);
			if(d != null && d.getNumber() != 0) {
				System.out.println(d.toString());
				
			}
			
			
		}
	}
}
