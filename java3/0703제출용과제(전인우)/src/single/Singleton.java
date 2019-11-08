package single;

import controller.accountController;
import controller.coffeeController;

public class Singleton {

	private static Singleton s = null;
	public accountController actCtrl;
	public coffeeController coffeeCtrl;
	
	private String loginId;
	private String name;
	
	private Singleton() {
		actCtrl = new accountController();
		coffeeCtrl = new coffeeController();
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
		}
		return s;
	}
	
	public String getLoginid() {
		return loginId;
	}
	
	public void setLoginid(String loginid) {
		this.loginId = loginid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
