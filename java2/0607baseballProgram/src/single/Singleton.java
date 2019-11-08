package single;

import java.util.TreeMap;

import dto.Human;

public class Singleton {

	private static Singleton single = null;
	public TreeMap<Integer, Human> TMap;
	
	private Singleton() {
		TMap = new TreeMap<Integer, Human>();
	}
	
	public static Singleton getInstance() {
		
		if(single == null) {
			single = new Singleton();
		}
		return single;
		
	}
	
}
