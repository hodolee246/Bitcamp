package main;

import java.util.Observable;
import java.util.Observer;

public class ObserverB implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		String str = (String)arg;
		
		System.out.println("Observer B 입니다. 통지 받았습니다." + str);

	}

}
