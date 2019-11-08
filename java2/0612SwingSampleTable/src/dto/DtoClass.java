package dto;

public class DtoClass {

	private int seq; 		// 상품 번호
	private String name ;	// 상품명
	private int money;		// 상품가격
	private String company;	// 상품회사
	
	public DtoClass() {
	
	}
	
	public DtoClass(int seq, String name, int money, String company) {
		super();
		this.seq = seq;
		this.name = name;
		this.money = money;
		this.company = company;
	}

	@Override
	public String toString() {
		return "DtoClass [seq=" + seq + ", name=" + name + ", money=" + money + ", company=" + company + "]";
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
}
