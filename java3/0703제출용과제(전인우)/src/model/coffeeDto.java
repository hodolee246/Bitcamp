package model;

import java.io.Serializable;

public class coffeeDto implements Serializable {
	/*CREATE TABLE COFFEE(
			SEQ NUMBER(8) PRIMARY KEY,
			NAME VARCHAR2(30) NOT NULL,
			CUPSIZE VARCHAR2(15) NOT NULL,
			SYRUP VARCHAR2(20) NOT NULL,
			ADDSHOT VARCHAR2(20) NOT NULL,
			ADDCREAM VARCHAR2(20) NOT NULL,
			CUP NUMBER(5) NOT NULL,
			MONEY NUMBER(8) NOT NULL
		);*/
	
	private String name;
	private String cupsize;
	private String syrup;
	private String addshot;
	private String addcream;
	private int cup;
	private int money;
	
	public coffeeDto() {
		// TODO Auto-generated constructor stub
	}

	
	public coffeeDto(String name, String cupsize, String syrup, String addshot, String addcream, int cup,
			int money) {
		super();
		this.name = name;
		this.cupsize = cupsize;
		this.syrup = syrup;
		this.addshot = addshot;
		this.addcream = addcream;
		this.cup = cup;
		this.money = money;
	}
	
	

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCupsize() {
		return cupsize;
	}

	public void setCupsize(String cupsize) {
		this.cupsize = cupsize;
	}

	public String getSyrup() {
		return syrup;
	}

	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}

	public String getAddshot() {
		return addshot;
	}

	public void setAddshot(String addshot) {
		this.addshot = addshot;
	}

	public String getAddcream() {
		return addcream;
	}

	public void setAddcream(String addcream) {
		this.addcream = addcream;
	}

	public int getCup() {
		return cup;
	}

	public void setCup(int cup) {
		this.cup = cup;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}


	@Override
	public String toString() {
		return "coffeeDto [name=" + name + ", cupsize=" + cupsize + ", syrup=" + syrup + ", addshot=" + addshot
				+ ", addcream=" + addcream + ", cup=" + cup + ", money=" + money + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
