package mytv;

public class MytvClass {

	boolean isPowerOn;
	int channel;
	int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 0; 
	
	int prev_channel;
	/*
	  	final 상수를 선언할떄에는 보통 대문자로 한다.
	  	final 은 선언시 값을 지정해주어야한다.
	  	final 은 상수이기 때문에 setter가 있을수 없다.
	  	
	  	int max;
	  	max = max_volume // 이런식으로 변수에 변수를 대입한다 처럼 (보일수)있기 때문에
	  					// 제 3자 프로그래머가 본다면 가독성이 조금 떨어진다
	  	max = MAX_VOLUME // 반면 이런식으로 대문자로 지칭한다면 아 저건 상수다 쉽게(보일수) 있기 떄문에
	  					// 제 3파 프로그래머가 봐도 쉽게 볼수있다.
	  
	 */
	
	
	public boolean isPowerOn() { // getter 에서는 isPowerOn 처럼 변수명이 is가 붙어있으면 Get대신 is가 붙는다
		return isPowerOn;
	}
	public void setPowerOn(boolean isPowerOn) { // setter 에서는 isPowerOn처럼 변수명에 is 가 붙어있으면 is 가 사라지고 set이 붙는다.
		this.isPowerOn = isPowerOn;
	}
	public int getChannel() { // 나머지는 변수명 앞에 get or set 이 붙고 변수명 첫글자가 대문자가 된다.
		return channel;
	}
	public void setChannel(int channel) {
		prev_channel = this.channel;	// 바뀌기 전에 저장해 놓는다.
		this.channel = channel;
	}
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public void gotoPrevChannel() {
		
		setChannel(prev_channel);
		
	}
	
	
	
	

}
