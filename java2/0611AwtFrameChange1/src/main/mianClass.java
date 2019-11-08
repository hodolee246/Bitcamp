package main;

import single.Singleton;

public class mianClass {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		s.fwin.setVisible(true);
		s.swin.setVisible(true);

	}

}
