package shape;

public abstract class Shape {

	Point p;	// 클래스 안에 클래스를 생성함 (composition)

	public Shape() {
		this(new Point(0,0));
	}
	
	Shape(Point p) {	// Shape (new Point(23, 45));
		this.p = p;
	}
	
	
	public Point getPosition() {
		return p;
	}
	
	public void setPosition(Point p) {
		this.p = p;
	}
	
	abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메소드 이다.

	
	
}

class Point {
	int x, y;
	public Point() {
		this(0,0);
	}

	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toStirng() {
		return "["+x+","+y+"]";
	}

}
