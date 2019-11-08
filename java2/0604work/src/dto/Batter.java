package dto;

public class Batter extends Human {

	private int ball;
	private int hit;
	private double hitper;
	
	public Batter() {
		
	}
	
	public Batter(int number, String name, int age, double height,
			int ball, int hit, double hitper) {
		super(number, name, age, height);
		this.ball = ball;
		this.hit = hit;
		this.hitper = hitper;
		
		
	}

	public int getBall() {
		return ball;
	}

	public void setBall(int ball) {
		this.ball = ball;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public double getHitper() {
		return hitper;
	}

	public void setHitper(double hitper) {
		this.hitper = hitper;
	}

	@Override
	public String toString() {
		return super.toString() + ball + "-" + hit + "-" + hitper;
	}
	
	
	
	
}
