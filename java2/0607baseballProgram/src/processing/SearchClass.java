package processing;

import java.util.Iterator;

import dao.DaoInterface;
import dto.Human;
import single.Singleton;

public class SearchClass{

	public SearchClass() {
		
	}
	
	public int search(String name) {
		Integer findIndex = -1;
		
		Singleton si = Singleton.getInstance();
		Iterator<Integer> it = si.TMap.keySet().iterator();
		while(it.hasNext()) {
			Integer key = it.next();
			Human dao = si.TMap.get(key);
			if(dao.getName().equals(name)){
				findIndex = key;
				if(key == -1) {
					System.out.println("해당 이름은 없습니다.");
				}
				return findIndex;
			}
		}
		return findIndex;
	}
	
}
