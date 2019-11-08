package single;

import java.util.TreeMap;

import dto.Human;

public class Singleton {

	private static Singleton single = null;
	public TreeMap<Integer, Human> TMap;
	public int key;
	public int sequence;
	private Singleton() {
		TMap = new TreeMap<Integer, Human>();
		sequence = 1001;
	}
	
	public static Singleton getInstance() {
		
		if(single == null) {
			single = new Singleton();
		}
		return single;
		
	}
	
}
