package dto;

import java.io.Serializable;

public class MemberDto implements Serializable{	// 네트워크, 웹일경우 반드시 임포트하자

	/*
	  아이디
	  패스워드
	  취미
	  나이
	  할말
	  
	  
	 */
	private String id;
	private String pwd;
	private String hobby[];
	private	String age;
	private String story;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}

	public MemberDto(String id, String pwd, String[] hobby, String age, String story) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.hobby = hobby;
		this.age = age;
		this.story = story;
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

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}
	
}
