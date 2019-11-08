package bit.com.a.model;

import java.io.Serializable;

public class MyData implements Serializable {

	private String name;
	private String phone;
	private String email;
	private String birthday;
	
	public MyData() {
		// TODO Auto-generated constructor stub
	}

	public MyData(String name, String phone, String email, String birthday) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "MyData [name=" + name + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday + "]";
	}
	
}
