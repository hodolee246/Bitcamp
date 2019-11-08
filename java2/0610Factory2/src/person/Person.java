package person;

import abstractweapon.AbstractWeapon;
import bomb.Bomb;
import weapon.Weapon;

public class Person {

	
	public Weapon m_weapon;
	public Bomb m_bomb;
	
	public void Create(AbstractWeapon aw) {
		this.m_weapon = aw.CreateWeapon();
		this.m_bomb = aw.CreateBomb();
	}
}
