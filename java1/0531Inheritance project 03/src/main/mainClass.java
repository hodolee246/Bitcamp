package main;

import ro.Robot;
import robot.DanceClass;
import robot.DrawClass;
import robot.SingClass;

public class mainClass {

	

	static void action(Robot rt) {
		
			if(rt instanceof DanceClass) {
				DanceClass d = (DanceClass)rt;
				d.Dance();
				
			}else if(rt instanceof SingClass) {
			((SingClass)rt).Sing();
				
			}else if(rt instanceof DrawClass) {
				DrawClass dc = (DrawClass)rt;
				dc.Draw();
				
			}
		}
	
	
	public static void main(String[] args) {
	
		Robot rt[] = new Robot[3];
		
		rt[0] = new DanceClass();
		rt[1] = new SingClass();
		rt[2] = new DrawClass();
		
		System.out.println();
		for (int j = 0; j < rt.length; j++) {
			
		
			action(rt[j]);
			// rt[i].Title(); title 클래스를 만들어서 override를 하면 이런식으로 접근도 가능하다.
			// rt[i].Title(); title 클래스의 오버라이딩 안에 자기 자신을 호출하게 시키면 오버라딩인
			// title 만 호출해도 title 안에 자기 자신을 호출을하니 print문이 출력된다.
		}
		
		
	}

	
	
}
