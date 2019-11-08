package single;

import java.util.TreeMap;

import dto.Date;

public class Singleton {
	private static Singleton s = null;
	public TreeMap<Integer, Date> Tmap;
	
	private Singleton() {
		Tmap = new TreeMap<Integer, Date>();
	}
	
	public static Singleton getInstance() {
		
		if(s == null) {
			s = new Singleton();
		}
		return s;
	
	}
	
}
