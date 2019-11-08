package dto;

import java.io.Serializable;

public class AdminChartDto implements Serializable {
	private static final long serialVersionUID = 3887468880408900865L;
	private int name;
	private int y;
	private String city;
	private int booking_count;
	
	public AdminChartDto() {
	}

	public AdminChartDto(int y) {
		super();
		this.y = y;
	}

	public AdminChartDto(int name, int y) {
		super();
		this.name = name;
		this.y = y;
	}

	public AdminChartDto(String city, int booking_count) {
		super();
		this.city = city;
		this.booking_count = booking_count;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getBooking_count() {
		return booking_count;
	}

	public void setBooking_count(int booking_count) {
		this.booking_count = booking_count;
	}

	@Override
	public String toString() {
		return "AdminChartDto [name=" + name + ", y=" + y + ", city=" + city + ", booking_count=" + booking_count + "]";
	}

}
