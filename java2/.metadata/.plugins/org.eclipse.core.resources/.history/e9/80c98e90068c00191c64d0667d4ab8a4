package processing;

import java.util.Iterator;

import dao.DaoInterface;
import dto.Human;
import single.Singleton;

public class AllPrintClass implements DaoInterface {

	@Override
	public void Process() {
		Singleton si = Singleton.getInstance();
		Iterator<Integer> it = si.TMap.keySet().iterator();
		
		Integer k = 0;
		while(it.hasNext()) {
			Integer key = it.next();
			k = key;
			Human hu = si.TMap.get(k);
			System.out.println(hu.toString());
		}

	}

}
