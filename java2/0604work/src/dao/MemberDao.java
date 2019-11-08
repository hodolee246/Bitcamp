package dao;

import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.fileClass;

public class MemberDao {
	Scanner	sc = new Scanner(System.in);
	
	private Human member[];
	private int sequence;	// +1 member의 index를 관리하기 위한 변수
	private int count;
	
	fileClass myfile;
	
	public MemberDao() {
		member = new Human[10];
		sequence = 1001;
		count = 0;
		myfile = new fileClass();
	}

	public MemberDao(int memberCount) {
		member = new Human[memberCount];
		sequence = 1001;
		count = 0;
		myfile = new fileClass("Lions");
		
		loadData();
	}
	
	public void insert() {
		
		System.out.println(">>선수등록");
		System.out.println("투수(1)/타자(2) 중 등록하고 싶은 포지션을 입력해 주십시오.");
		System.out.print(">>");
		
		int pos = sc.nextInt();
		
		// 맨처음에는 이름을 입력받는다.
		System.out.print("이름 >>");
		String name = sc.next();
		// 나이 입력
		System.out.print("나이 >>");
		int age = sc.nextInt();
		// 키 입력
		System.out.print("키 >>");
		double height = sc.nextDouble();
		
		Human human = null;
		// pitcher
		if(pos == 1) {
			// 승
			System.out.print("승 >>");
			int win = sc.nextInt();
			
			// 패
			System.out.print("패 >>");
			int lose = sc.nextInt();
			
			// 방어율
			System.out.print("방어율 >>");
			double defence = sc.nextDouble();
			
			human = new Pitcher(sequence, name, age, height, win, lose, defence);
		}
		
		// batter
		else {
			sequence = 2001;
			
			// 볼수
			System.out.print("볼수 >>");
			int ball = sc.nextInt();
			
			// 안타 횟수
			System.out.print("안타 횟수 >>");
			int hit = sc.nextInt();
			
			// 안타율
			System.out.print("안타율 >>");
			double hitper = sc.nextDouble();
			
			human = new Batter(sequence, name, age, height, ball, hit, hitper);
			
			
			/*
			 				// 위에 투수는 1001~부터 시작하고 타자는 2001부터 시작하게 설정하면 쉽게
			 				// 나중에 찾거나 삭제하거나 등등 할때 하기가 쉽다.
			 human = new Batter(sequence + 1000, 
			  
			 */
			
		}
		member[count] = human;
		
		sequence++;
		count++;
	}
	
	public void delete() {
		System.out.print("삭제하고 싶은 이름 >>");
		String name = sc.next();
		
		int findIndex = search(name);		
		if(findIndex == -1) {
			System.out.println("데이터를 찾지 못했습니다");
			return;
		}
		
		member[findIndex].setNumber(0);
		member[findIndex].setName("");
		member[findIndex].setAge(0);
		member[findIndex].setHeight(0.0);
		
		if(member[findIndex] instanceof Pitcher) {
			Pitcher p = (Pitcher)member[findIndex];
			p.setWin(0);
			p.setLose(0);
			p.setDefence(0.0);
		}
		else if(member[findIndex] instanceof Batter){
			Batter b = (Batter)member[findIndex];
			b.setBall(0);
			b.setHit(0);
			b.setHitper(0.0);
		}		
	}
	
	public void select() {
		System.out.print("검색하고 싶은 이름 >>");
		String name = sc.next();
		
		int findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("데이터를 찾지 못했습니다.");
			return;
		}
		System.out.println("검색된 데이터는>>");
		Human h = member[findIndex];
		System.out.println(h.toString());
	}
	
	public void update() {
		System.out.print("수정하고 싶은 이름 >>");
		String name = sc.next();
		
		int findIndex = search(name);
		
		if(findIndex == -1) {
			System.out.println("데이터를 찾지 못했습니다.");
			return;
		}
		if(member[findIndex] instanceof Pitcher) {
			System.out.println("수정할 데이터를 입력해 주세요");
			System.out.print("승 >>");
			int win = sc.nextInt();
			
			// 패
			System.out.print("패 >>");
			int lose = sc.nextInt();
			
			// 방어율
			System.out.print("방어율 >>");
			double defence = sc.nextDouble();
			
			Pitcher p = (Pitcher)member[findIndex];
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
		}
		else if(member[findIndex] instanceof Batter) {
			// 볼수
				System.out.print("볼수 >>");
				int ball = sc.nextInt();
						
			// 안타 횟수
				System.out.print("안타 횟수 >>");
				int hit = sc.nextInt();
						
			// 안타율
				System.out.print("안타율 >>");
				double hitper = sc.nextDouble();
				
				Batter b = (Batter)member[findIndex];
				b.setBall(ball);
				b.setHit(hit);
				b.setHitper(hitper);
		}
	}
	
	public void allprint() {
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && !member[i].getName().equals("")) {
				Human h = member[i];
				System.out.println(h.toString());
			}
		}
	}
	
	public int search(String name) {
		
		int findIndex = -1;
		for (int i = 0; i < member.length; i++) {
			Human h = member[i];
			if(h != null && !h.getName().equals("")) {
				if(name.equals(h.getName())) {
					findIndex = i;
					break;
				}
			}
		}
		return findIndex;
	}
	
	public void saveData() {
		int datalength = 0;
		
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && member[i].getName().equals("")) {
				datalength++;
			}
		}
		
		String datas[] = new String[datalength];
		// 0
		// 1
		// 2  	- t삭제
		// 3
		
		int len = 0;
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && member[i].getName().equals("")) {
				datas[len] = member[i].toString();
				len++;
			}
		}
		
		for (int i = 0; i < datas.length; i++) {
			System.out.println(i + "datas:" +" " + datas[i]);
		}
		
		myfile.writeFile(datas);
		
	}
	
	public void loadData() {
		// member[] <- String[] 
		
		String datas[] = myfile.readFile();
		/*
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
		*/
		// 문자열을 자른 후에 Pitcher, Batter에 맞게 데이터를 넣어 준다.
		
	}
	
}

















