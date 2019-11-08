package project;

import java.util.Arrays;

/*
	String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String hobby[] = req.getParameterValues("hobby");
		String age = req.getParameter("age");
		String ahhh = req.getParameter("ahhh");
 */

public class dto {
	
	private String id;
	private String pwd;
	private String hobby[];
	private String age;
	private String ahhh;
	
	public dto() {
	
	}

	public dto(String id, String pwd, String[] hobby, String age, String ahhh) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.hobby = hobby;
		this.age = age;
		this.ahhh = ahhh;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String[] getHobby() {
		return hobby;
	}

	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAhhh() {
		return ahhh;
	}

	public void setAhhh(String ahhh) {
		this.ahhh = ahhh;
	}

	@Override
	public String toString() {
		return "dto [id=" + id + ", pwd=" + pwd + ", hobby=" + Arrays.toString(hobby) + ", age=" + age + ", ahhh="
				+ ahhh + "]";
	}
	
	
}

