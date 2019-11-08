package abstractweapon;

import bomb.Bomb;
import bomb.C4;
import weapon.Gun;
import weapon.Weapon;

public class AtypeClass implements AbstractWeapon {

	@Override
	public Weapon CreateWeapon() {
		// TODO Auto-generated method stub
		return new Gun();
	}

	@Override
	public Bomb CreateBomb() {
		// TODO Auto-generated method stub
		return new C4();
	}

}
