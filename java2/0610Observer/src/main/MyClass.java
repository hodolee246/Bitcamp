package main;

import java.util.Observable;

public class MyClass extends Observable{

	private String preArg = null;
	
	@Override
	public void notifyObservers(Object arg) {
		
		String str = (String)arg;
		
		// 변화가 없다(통지를 해 주지 않는다)
		if(str.equals(preArg)) return;
		
		preArg = str;
		
		// packet
		
		setChanged();
		
		super.notifyObservers(arg);
		
		clearChanged(); // reset
	}
	
	
	
}
