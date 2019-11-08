package main;

import mytv.MytvClass;

public class mainClass {

	public static void main(String[] args) {
		
		MytvClass t = new MytvClass();

		//public void setChannel(int channel) {
		//prevchannel = this.channel;
		//this.channel = channel;
		t.setChannel(10);
		System.out.println("CH:" + t.getChannel());
		t.setChannel(20);
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
		t.gotoPrevChannel();
		System.out.println("CH:" + t.getChannel());
	}

}
