package dao;

import java.util.ArrayList;
import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	private int sequence;
	private int memberCount;
	ArrayList<Human> alh = new ArrayList<Human>();
	
	public MemberDao() {
		
		sequence = 1001;
		memberCount = 0;
		
	}
	
	public void insert() {
		
		System.out.println("(1)투수 (2)타자");
		int po = sc.nextInt();
		
		System.out.println("이름");
		String name = sc.next();
		
		System.out.println("나이");
		int age = sc.nextInt();
		
		System.out.println("키");
		double height = sc.nextDouble();
		
		if(po == 1) {
			System.out.println("승");
			int win = sc.nextInt();
			
			System.out.println("패");
			int lose = sc.nextInt();
			
			System.out.println("방어율");
			double defence = sc.nextDouble();
			
			Human hu = new Pitcher(sequence, name, age, height, win, lose, defence);
			alh.add(hu);
		} else if(po ==2) {
			System.out.println("볼수");
			int ball = sc.nextInt();
			
			System.out.println("안타");
			int hit = sc.nextInt();
			
			System.out.println("출루율");
			double hitavg = sc.nextDouble();
			
			Human hu = new Batter(sequence, name, age, height, ball, hit, hitavg);
			alh.add(hu);
		}
		sequence++;
	}
	
	public void delete() {
		
		System.out.println("삭제할 번호를 입력해주세요");
		int num = sc.nextInt();
		for (int i = 0; i < alh.size(); i++) {
			Human h = alh.get(i);
			if(h.getNumber() == num) {
				alh.remove(i);
				return;
			}
			
		}
		System.out.println("해당 번호는 없습니다.");
		
	}
	
	public void select() {
		
		System.out.println("검색할 번호를 입력해주세요.");
		int num = sc.nextInt();
		
		for (int i = 0; i < alh.size(); i++) {
			Human h = alh.get(i);
			if(h.getNumber() == num) {
				System.out.println(h.toString());
				return;
			}
		}
		System.out.println("해당 번호는 없습니다.");
		
	}
	
	public void update() {
		System.out.println("수정할 번호를 입력해주세요.");
		int num = sc.nextInt();
		for (int i = 0; i < alh.size(); i++) {
			
			Human h = alh.get(i);
			if(h.getNumber() == num && num < 2000) {
				System.out.println("선수의 이름을 입력해주세요.");
				String name = sc.next();
				
				System.out.println("선수의 나이를 입력해주세요.");
				int age = sc.nextInt();
				
				System.out.println("선수의 키를 입력해주세요.");
				double height = sc.nextDouble();
				
				System.out.println("승수를 입력해주세요.");
				int win = sc.nextInt();
				
				System.out.println("패배를 입력해주세요.");
				int lose = sc.nextInt();
				
				System.out.println("방어율을 입력해주세요.");
				double defence = sc.nextDouble();
				
				h = new Pitcher(sequence, name, age, height, win, lose, defence);
				alh.set(i, h);
				sequence++;
				return;
			}
			
		}
		System.out.println("해당 번호는 없습니다.");
		
	}
	
	public void allprint() {
		
		for (int i = 0; i < alh.size(); i++) {
			Human h = alh.get(i);
			System.out.println(h.toString());
		}
		
	}
}















