package processing;

import java.util.Scanner;

import dao.DaoInterface;
import single.Singleton;

public class DeleteClass implements DaoInterface{

	public DeleteClass() {
		
	}


	@Override
	public void Process() {
		Singleton si = Singleton.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력해주세요.");
		String name = sc.next();
		SearchClass ss = new SearchClass();
		int key = ss.search(name);
		
		if(key != -1) {
			si.TMap.remove(key);			
		}else {
			System.out.println("해당 이름은 없습니다.");
		}
		
	}
	
	
}
