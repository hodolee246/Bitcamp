package single;

import view.FrontWindow;
import view.SubWIndow;

public class Singleton {
	
	private static Singleton s = null;
	
	public  FrontWindow fwin;
	public 	SubWIndow swin;
	
	
	private Singleton() {
		fwin = new FrontWindow();
		swin = new SubWIndow();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
			
		}
		return s;
	}
}
