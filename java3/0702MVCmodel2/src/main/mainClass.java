package main;

import db.DBConnection;
import single.Singleton;

public class mainClass {

	public static void main(String[] args) {
		DBConnection.initConnection();

		Singleton s = Singleton.getInstance(); // Controller 생성된다
		s.memCtrl.login();	// 1
	}

}
