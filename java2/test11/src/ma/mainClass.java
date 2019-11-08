package ma;

import java.awt.AWTException;
import java.awt.Robot;

import tt.window;

public class mainClass {

	public static void main(String[] args) {
		
		int x, y;
		
		x = (int)(Math.random()*200);
		y = (int)(Math.random()*200);
		
		try {
			Robot ro = new Robot();
			for (int i = 0; i < 100; i++) {
				ro.delay(1000 * 5);
				ro.mouseMove(x, y);
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
