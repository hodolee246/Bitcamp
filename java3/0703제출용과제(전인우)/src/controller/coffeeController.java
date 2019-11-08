package controller;

import java.util.List;

import model.coffeeDto;
import service.coffeeService;
import service.impl.coffeeServiceImpl;
import view.coffeeMenuView;
import view.coffeeMoneyView;
import view.coffeeOrderView;

public class coffeeController {

	coffeeService service = new coffeeServiceImpl();
	
	public void moneyview() {
			new coffeeMoneyView();
			
	}
	
	public boolean addCoffee(String name, String cupsize, String syrup, String addshot, String addcream, int cup, int money) {
		return service.addCoffee(name, cupsize, syrup, addshot, addcream, cup, money);
	}
	
	public List<coffeeDto> getCoffeeList(){
		return service.getCoffeeList();
	}
	
	public void orderview() {
		new coffeeOrderView();
	}
	
	public int howMuch(String name,String v_size, int v_cups) {
		return service.howMuch(name, v_size, v_cups);
	}
	
	public void setTrue() {
		coffeeMenuView cmv = new coffeeMenuView();
		cmv.gettrue();
	}

	
	
	
}
