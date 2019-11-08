package processing;

import java.util.Scanner;

import dao.DaoInterface;
import dto.Human;
import single.Singleton;

public class SelectClass implements DaoInterface{

	public SelectClass() {
		
	}

	@Override
	public void Process() {
		Scanner sc = new Scanner(System.in);
		Singleton si = Singleton.getInstance();
		System.out.println("검색할 이름을 입력해주세요.");
		String name = sc.next();
		
		SearchClass ss = new SearchClass();
		int key = ss.search(name);
		
		Human hu = si.TMap.get(key);
		System.out.println(hu.toString());
	}
	
	
	
}
