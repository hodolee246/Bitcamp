package main;

import java.util.ArrayList;
import java.util.List;

import abstractweapon.AtypeClass;
import abstractweapon.BtypeClass;
import person.Person;

public class mainClass {

	public static void main(String[] args) {
	
		List<Person> aa = new ArrayList<Person>();
		
		Person human = new Person();
		human.Create(new BtypeClass());

		aa.add(human);
		
		Person human2 = new Person();
		human2.Create(new AtypeClass());
		
		aa.add(human2);
		
		for (int i = 0; i < aa.size(); i++) {
			Person p = aa.get(i);
			p.m_bomb.DrawBomb();
			p.m_weapon.DrawWeapone();
		}
		
		
		
		
	}

}
