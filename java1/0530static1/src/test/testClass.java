package test;

public class testClass {

	
	private int year;
	
	private String ball;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getball() {
		return ball;
	}

	public void setball(String ball) {
		this.ball = ball;
	}

	@Override
	public String toString() {
		return "testClass [year=" + year + ", ball=" + ball + "]";
	}
	
	
}
