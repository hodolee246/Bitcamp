package shape;

public class CircleClass extends Shape {

	double r ;
	
	public CircleClass() {
		super();
	}
	
	public CircleClass(double r, int x, int y) {
		this(new Point(x, y), r);
	}
	
	public CircleClass(Point p, double r) {
		super(p);
		this.r = r;
		
	}
	
	@Override
	double calcArea() {
		// TODO Auto-generated method stub
		return (r*r* Math.PI);
	}

}
