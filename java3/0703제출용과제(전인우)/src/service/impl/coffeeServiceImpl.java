package service.impl;

import java.util.List;

import dao.coffeeDao;
import dao.impl.coffeeDaoImpl;
import model.coffeeDto;
import service.coffeeService;

public class coffeeServiceImpl implements coffeeService {

	coffeeDao dao = new coffeeDaoImpl();
	@Override
	public boolean addCoffee(String name, String cupsize, String syrup, String addshot, String addcream, int cup,
			int money) {
		return dao.addCoffee(name, cupsize, syrup, addshot, addcream, cup, money);
	}
	@Override
	public List<coffeeDto> getCoffeeList() {
		return dao.getCoffeeList();
	}
	@Override
	public int howMuch(String name, String v_size, int v_cups) {
		return dao.howMuch(name, v_size, v_cups);
	}

	
}
