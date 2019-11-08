package dropship;

import main.Unit;

public class DropShip extends Unit {

	int x, y ;
	
	void load() {
		// 대상을 태운다
		System.out.println("DropShip 유닛을 태운다");
	}
	void unload() {
		// 대상을 내린다.
		System.out.println("DropShip 유닛을 내린다");
	}
	
	
}


