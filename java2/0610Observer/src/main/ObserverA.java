package main;

import java.util.Observable;

public class ObserverA implements java.util.Observer {

	@Override
	public void update(Observable o, Object arg) {
		String str = (String)arg;
		
		System.out.println("Observer A 입니다. 통지 받았습니다." + str);
		
	}

}
