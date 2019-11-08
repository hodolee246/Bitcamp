package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Batter;
import dto.Human;
import dto.Pitcher;
import file.FileClass;

public class MemberDao {
	Scanner sc = new Scanner(System.in);
	
	// private Human member[];
	private List<Human> list;
	
	private int sequence;	// +1 member의 index를 관리하기 위한 변수
	// private int memberCount;
	
	FileClass myfile;
	
	public MemberDao() {
		// member = new Human[10];
		list = new ArrayList<Human>();
		
		sequence = 1001;
	//	memberCount = 0;
		myfile = new FileClass();
	}
	
	public MemberDao(int count) {		
	//	member = new Human[count];		
		list = new ArrayList<Human>();
		
		myfile = new FileClass("lions");	
				
		loadData();	// 파일로부터 배열(member)에 셋팅
		/*
		int lastNum = 0;
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null) {
				lastNum = i;
			}else {
				break;
			}
		}
		*/
		int lastNum = 0;		
		if(list.isEmpty()) {
			lastNum = 1001;
		}else {		
			Human h = list.get(list.size() - 1);	// 0 1  	
			lastNum = h.getNumber();
					
		//	memberCount = lastNum + 1;
			sequence = 1000 + (lastNum % 1000 + 1);	// 1001
		}
	//	System.out.println("memberCount:" + memberCount);
		System.out.println("sequence:" + sequence);
	}
	
	public void insert() {
		
		System.out.println(">>선수등록");
		System.out.println("투수(1)/타자(2) 중 등록하고 싶은 포지션을 입력해 주십시오.");
		System.out.print(">>");		
		int pos = sc.nextInt();
		
		// 이름
		System.out.print("이름 >>");	
		String name = sc.next();
		
		// 나이
		System.out.print("나이 >>");
		int age = sc.nextInt();
		
		// 키
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
		else if(pos == 2){			
			// 타수
			System.out.print("타수 >>");
			int bat = sc.nextInt();
			
			// 안타수
			System.out.print("안타수 >>");
			int hit = sc.nextInt();
			
			// 타율
			System.out.print("타율 >>");
			double hitAvg = sc.nextDouble();
						
			human = new Batter(sequence + 1000, name, age, height, bat, hit, hitAvg);	
		}
		list.add(human);
		// member[memberCount] = human;		
		sequence++;
		//memberCount++;
	}
	public void delete() {
		System.out.print("삭제하고 싶은 이름 >>");
		String name = sc.next();
		
		int findIndex = search(name);		
		if(findIndex == -1) {
			System.out.println("데이터를 찾지 못했습니다");
			return;
		}
				
		/*
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
			
		}	*/	
		Human h = list.remove(findIndex);		
		System.out.println(h.getName() + "의 데이터를 삭제 하였습니다");
	}
	public void select() {
		System.out.print("검색하고 싶은 이름 >>");
		String name = sc.next();
		
		int findIndex = search(name);		
		if(findIndex == -1) {
			System.out.println("데이터를 찾지 못했습니다");
			return;
		}
		
		System.out.println("검색된 데이터는 >>");
		
		// Human h = member[findIndex];
		Human h = list.get(findIndex);
		System.out.println(h.toString());
	}
	public void update() {
		System.out.print("수정하고 싶은 이름 >>");
		String name = sc.next();
		
		int findIndex = search(name);		
		if(findIndex == -1) {
			System.out.println("데이터를 찾지 못했습니다");
			return;
		}
		
		System.out.println("수정할 데이터를 입력해 주십시오");
		// if(member[findIndex] instanceof Pitcher) {
		Human h = list.get(findIndex);
		if(h instanceof Pitcher) {
			// 승
			System.out.print("승 >>");
			int win = sc.nextInt();
			
			// 패
			System.out.print("패 >>");
			int lose = sc.nextInt();
			
			// 방어율
			System.out.print("방어율 >>");
			double defence = sc.nextDouble();
			
			//Pitcher p = (Pitcher)member[findIndex];
			Pitcher p = (Pitcher)h;
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);			
		}
		else if(h instanceof Batter) {
			
		}
	}
	public void allprint() {
		/*
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && !member[i].getName().equals("")) {
				Human h = member[i];
				System.out.println(h.toString());
			}
		}*/
		if(list.size() == 0) return;
		
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			System.out.println(h.toString());
		}
	}
		
	public int search(String name) {
		int findIndex = -1;
		/*
		for (int i = 0; i < member.length; i++) {
			Human h = member[i];
			if(h != null && !h.getName().equals("")) {
				if(name.equals(h.getName())) {
					findIndex = i;
					break;
				}
			}
		}
		*/
		for (int i = 0; i < list.size(); i++) {
			Human h = list.get(i);
			if(name.equals(h.getName())) {
				findIndex = i;
				break;
			}
		}		
		return findIndex;
	}
	
	public void saveData() {
		
		int datalength = 0;
		/*
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && !member[i].getName().equals("")) {
				datalength++;
			}
		}
		*/
		datalength = list.size();
		
		String datas[] = new String[datalength];	
		// 0
		// 1
		// 2	- 삭제
		// 3
		
		int len = 0;
		/*
		for (int i = 0; i < member.length; i++) {
			if(member[i] != null && !member[i].getName().equals("")) {
				datas[len] = member[i].toString();
				len++;
			}
		}
		*/
		for (int i = 0; i < list.size(); i++) {
			datas[len] = list.get(i).toString();
			len++;
		}
		
		for (int i = 0; i < datas.length; i++) {
			System.out.println(i + "datas:" + datas[i]);
		}
		
		myfile.writeFile(datas);
	}
	
	public void loadData() {
		// Human member[] <- String[]
		
		String datas[] = myfile.readFile();
		/*
		//  
		for (int i = 0; i < datas.length; i++) {
			System.out.println(datas[i]);
		}
		*/
		// 문자열을 자른 후에 Pitcher, Batter에 맞게 데이터를 넣어 준다
		
		for (int i = 0; i < datas.length; i++) {			
			String str = datas[i];			// 1001-hgd-1-1.0-1-1-1.0
			String data[] = str.split("-"); // 1001 hgd 1 1.0 1 1 1.0
											// 번호, 이름, 나이, 키, 승, 패, 방어율  	
			int number = Integer.parseInt(data[0]);	// 투수/타자
			if(number < 2000) {	// 투수
				Pitcher p = new Pitcher(number, 
										data[1], 
										Integer.parseInt(data[2]), 
										Double.parseDouble(data[3]), 
										Integer.parseInt(data[4]), 
										Integer.parseInt(data[5]), 
										Double.parseDouble(data[6]));
				// member[i] = p;
				list.add(p);
			}
			else {				// 타자
				Batter b = new Batter(number, 	// number
										data[1], 	// name
										Integer.parseInt(data[2]),	// age 
										Double.parseDouble(data[3]), // height
										Integer.parseInt(data[4]), 	// bat
										Integer.parseInt(data[5]), 	// hit
										Double.parseDouble(data[6])); // hitAvg
				// member[i] = b;
				list.add(b);
			}			
		}		
	}	
}




