package dto;

public class Date {

	
	private int number ;
	private String date;
	private int money;
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "Date [number=" + number + ", date=" + date + ", money=" + money + "]";
	}
	
	
	
}
