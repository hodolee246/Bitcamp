package dto;

public class coffeDto {
	private String coffee;
	private String size_short;
	private String size_tall;
	private String size_grande;
	
	public coffeDto() {
		// TODO Auto-generated constructor stub
	}

	public coffeDto(String coffee, String size_short, String size_tall, String size_grande) {
		super();
		this.coffee = coffee;
		this.size_short = size_short;
		this.size_tall = size_tall;
		this.size_grande = size_grande;
	}

	public String getCoffee() {
		return coffee;
	}

	public void setCoffee(String coffee) {
		this.coffee = coffee;
	}

	public String getSize_short() {
		return size_short;
	}

	public void setSize_short(String size_short) {
		this.size_short = size_short;
	}

	public String getSize_tall() {
		return size_tall;
	}

	public void setSize_tall(String size_tall) {
		this.size_tall = size_tall;
	}

	public String getSize_grande() {
		return size_grande;
	}

	public void setSize_grande(String size_grande) {
		this.size_grande = size_grande;
	}

	@Override
	public String toString() {
		return "coffeDto [coffee=" + coffee + ", size_short=" + size_short + ", size_tall=" + size_tall
				+ ", size_grande=" + size_grande + "]";
	}
	
	
}
