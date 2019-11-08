package project;

import java.util.Arrays;

/*
 	이름 텍스트
	나이 셀렉트
	성별 라디오
	취미 체크
	생년 제이커리
	연봉 셀렉트 
 */

public class ummDto {

	private String name;	//이름
	private String age;		//나이
	private String mw;		//성별
	private String[] hb;	//취미
	private String birthday;	//생년월일
	private String sal;		//연봉
	
	public ummDto() {
		
	}

	public ummDto(String name, String age, String mw, String[] hb, String birthday, String sal) {
		super();
		this.name = name;
		this.age = age;
		this.mw = mw;
		this.hb = hb;
		this.birthday = birthday;
		this.sal = sal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getMw() {
		return mw;
	}

	public void setMw(String mw) {
		this.mw = mw;
	}

	public String[] getHb() {
		return hb;
	}

	public void setHb(String[] hb) {
		this.hb = hb;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSal() {
		return sal;
	}

	public void setSal(String sal) {
		this.sal = sal;
	}

	@Override
	public String toString() {
		return "ummDto [name=" + name + ", age=" + age + ", mw=" + mw + ", hb=" + Arrays.toString(hb) + ", birthday="
				+ birthday + ", sal=" + sal + "]";
	}
	
	

}	