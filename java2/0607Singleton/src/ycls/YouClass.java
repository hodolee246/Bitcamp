package ycls;

import single.SingletonClass;

public class YouClass {

	
	private int younum;
	private String youname;
	public YouClass() {
		
	}

	@Override
	public String toString() {
		return "YouClass [younum=" + younum + ", youname=" + youname + "]";
	}

	public int getYounum() {
		return younum;
	}
	
	public void method() {
		SingletonClass sc = SingletonClass.getInstance();
		younum = sc.num;
		
	}

	public void Function() {
		SingletonClass sc = SingletonClass.getInstance();
		youname = sc.name;
		System.out.println(sc.name);
	}
	public void setYounum(int younum) {
		this.younum = younum;
	}
	
}
