package shape;

public class Circle extends Shape {
	double r;
	int width;
	int height;
	@Override
	double calcArea() {
		// TODO Auto-generated method stub
		return calcArea(r);
	}

	double calcArea(double r) {
		
		
		r = (width * height);
		
		this.r = r;
		
		return this.r;
		
	}

	
}
