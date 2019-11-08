package service;

import java.util.List;

import model.coffeeDto;

public interface coffeeService {

	public boolean addCoffee(String name, String cupsize, String syrup, String addshot, String addcream, int cup, int money);

	public List<coffeeDto> getCoffeeList();

	public int howMuch(String name,String v_size, int v_cups);
}
