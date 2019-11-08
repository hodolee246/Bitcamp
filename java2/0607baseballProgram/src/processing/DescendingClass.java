package processing;

import java.util.Iterator;
import java.util.TreeMap;

import dao.DaoInterface;
import dto.Human;
import dto.Pitcher;
import single.Singleton;

public class DescendingClass implements DaoInterface{

	@Override
	public void Process() {
		Singleton ss = Singleton.getInstance();
		
		
		
	Iterator<Integer> it = ss.TMap.descendingKeySet().iterator();
	TreeMap<Double, Pitcher> tmap = new TreeMap<Double, Pitcher>();
	while(it.hasNext()) {

		int key = it.next();
		
		Human h = ss.TMap.get(key);
		if(h instanceof Pitcher) {
			Pitcher p = (Pitcher)h;
			tmap.put(p.getDefence(), p);
		}
	}
		Iterator<Double> iter = tmap.descendingKeySet().iterator();
		
		while(iter.hasNext()) {
			double key = iter.next();
			Pitcher p = tmap.get(key);
			System.out.println(p.toString());
		}
	
		
		
	}

}
