package dto;

import java.io.Serializable;
/*
 CREATE TABLE USERDTO(
	ID VARCHAR2(50),
	NAME VARCHAR2(50),
	AGE NUMBER(20),
	JOINDATE DATE
);
 */
public class UserDto implements Serializable {

	
	private String id;
	private String name;
	private int age;
	private String joindate;
	
	
	public UserDto() {
		// TODO Auto-generated constructor stub
	}


	public UserDto(String id, String name, int age, String joindate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.joindate = joindate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getJoindate() {
		return joindate;
	}

	
	public void setJoindate(String joindate) {
		this.joindate = joindate;
	}
	
	
	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", age=" + age + ", joindate=" + joindate + "]";
	}
}
