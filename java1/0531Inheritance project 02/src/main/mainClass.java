package main;

import dropship.DropShip;
import marine.Marine;
import tank.Tank;

public class mainClass extends Unit{

	public static void main(String[] args) {
		
		
		Marine unit1[] = new Marine[10];
		Tank unit2[] = new Tank[5];
		DropShip unit3[] = new DropShip[3];

		
		// 200
		Unit unit[] = new Unit[6];
		unit[0] = new Marine();
		unit[1] = new Marine();
		unit[2] = new Marine();
		
		unit[3] = new Tank();
		
		unit[4] = new Marine();
		
		unit[5] = new DropShip();
		
		// instanceof
		
		for (int i = 0; i < unit.length; i++) {
			if(unit[i] instanceof Marine) {
				Marine m = (Marine)unit[i];
				
						
			}
			else if(unit[i] instanceof Tank) {
				
			}
		
			else if(unit[i] instanceof DropShip) {
			
		}
			
		}	
		
	}

}
