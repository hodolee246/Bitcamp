package single;

import controller.BbsController;
import controller.MemberController;

public class Singleton {
	private static Singleton s = null;
	public MemberController memCtrl;
	public BbsController bbsCtrl;
	
	private String loginId;
	
	private Singleton() {	
		memCtrl = new MemberController();
		bbsCtrl = new BbsController();
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
	
}
