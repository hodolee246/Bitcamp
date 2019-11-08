package processing;

import java.util.Scanner;

import dao.DaoInterface;
import dto.Batter;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class UpdateClass implements DaoInterface{
	Scanner sc = new Scanner(System.in);
	Singleton si = Singleton.getInstance();
	public UpdateClass() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void Process() {
		System.out.println("수정할 이름을 입력해주세요.");
		String name = sc.next();
		SearchClass ss = new SearchClass();
		int key = ss.search(name);
		Human h = si.TMap.get(key);
		if(h instanceof Pitcher) {
			System.out.println("승수 입력");
			int win = sc.nextInt();
			
			System.out.println("패 입력");
			int lose = sc.nextInt();
			
			System.out.println("방어율 입력");
			double defence = sc.nextDouble();
			
			Pitcher p = (Pitcher)h;
			p.setWin(win);
			p.setLose(lose);
			p.setDefence(defence);
		}
		else if(h instanceof Batter) {
			System.out.println("볼수 입력");
			int ball = sc.nextInt();
			
			System.out.println("안타횟수 입력");
			int hit = sc.nextInt();
			
			System.out.println("출루율 입력");
			double hitavg = sc.nextDouble();
			
			Batter b = (Batter)h;
			b.setBall(ball);
			b.setHit(hit);
			b.setHitavg(hitavg);
		}
		
		
	}

}
