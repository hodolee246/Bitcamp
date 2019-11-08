package abstractweapon;

import bomb.Bomb;
import bomb.Dynamite;
import weapon.Sword;
import weapon.Weapon;

public class BtypeClass implements AbstractWeapon {

	@Override
	public Weapon CreateWeapon() {
		// TODO Auto-generated method stub
		return new Sword();
	}

	@Override
	public Bomb CreateBomb() {
		// TODO Auto-generated method stub
		return new Dynamite();
	}

}
