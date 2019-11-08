package dao;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import javax.sound.midi.Sequence;

import dto.Batter;
import dto.Human;
import dto.Pitcher;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	private int squence;
	
	TreeMap<Integer, Human> TMap = new TreeMap<Integer, Human>();
	
	public MemberDao() {
		squence = 1001;
	}
	
	public void insert() {
		System.out.println("(1) 투수 (2) 타자 ");
		int no = sc.nextInt();
		
		System.out.println("선수 이름");
		String name = sc.next();
		
		System.out.println("선수 나이");
		int age = sc.nextInt();
		
		System.out.println("선수 키");
		double height = sc.nextDouble();
		Human human = null;
		if(no == 1) {
			System.out.println("승");
			int win = sc.nextInt();
			
			System.out.println("패");
			int lose = sc.nextInt();
			
			System.out.println("방어율");
			double defence =sc.nextDouble();
			
		human = new Pitcher(squence, name, age, height, win, lose, defence);
		TMap.put(squence, human);
		
		
		} else if(no == 2){
			System.out.println("볼수");
			int ball = sc.nextInt();
			
			System.out.println("안타");
			int hit = sc.nextInt();
			
			System.out.println("출루율");
			double hitavg = sc.nextDouble();
			
			human = new Batter(squence + 1000, name, age, height, ball, hit, hitavg);
			TMap.put(squence, human);
		}
		
		squence++;
	}
	
	public void delete() { // 딜리트 수정 셀렉트 업데이트 만들고 메인만들기
		System.out.println("번호");
		int num = sc.nextInt();
		
		for (int i = 0; i < TMap.size(); i++) {
			Human hu = TMap.get(i);
			if(hu.getNumber() == num) {
				TMap.remove(i);
			}
		}
		System.out.println("번호가 없습니다.");
	}
	
	
	public void allprint() {
		
		Iterator<Integer> it = TMap.keySet().iterator();
		while(it.hasNext()) {
			int key = it.next();
			Human value = TMap.get(key);
			
			System.out.println(key + "" + value.toString());
	}
		
		
	}
	
	
	
	
	
	
}
