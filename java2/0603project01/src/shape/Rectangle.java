package shape;

public class Rectangle extends Shape {

	int width;
	int height;
	public Rectangle() {
		super();
	}
	
	public Rectangle(int width, int height) {
		
		this(new Point(0, 0), width, height);
		
		
	}
	
	public Rectangle(Point p, int width, int height) {
		super(p);
		this.width = width;
		this.height = height;
	}
	
	
	double calcArea() {
		
		return (this.width * this.height);
	}
	
	
	

}
