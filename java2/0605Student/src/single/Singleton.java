package single;

import java.util.ArrayList;

import dto.DtoStudent;

public class Singleton {
	private static Singleton s = null;
	public ArrayList<DtoStudent> dsa;
	
	
	
	private Singleton() {
		dsa = new ArrayList<DtoStudent>();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
		
	}
}
