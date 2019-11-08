package main;

public class mainClass {

	public static void main(String[] args) {
		Point3D p1 =new Point3D(1, 2, 3);
		Point3D p2 =new Point3D(1, 2, 3);

		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(" p1 == p2?" +(p1==p2));
		System.out.println(" p1 equlse(p2)?" +(p2.equals(p1)));
	}

}
