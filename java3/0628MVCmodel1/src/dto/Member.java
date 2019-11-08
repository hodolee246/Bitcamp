package dto;

import java.io.Serializable;
/*
 -- 무결성에 관한걸 다 지워라
DROP TABLE MEMBER
CASCADE CONSTRAINTS;


CREATE TABLE MEMBER(
	ID VARCHAR2(20) PRIMARY KEY,	-- 아이디는 중복이 되면 안된다 == 기본키
	PWD VARCHAR2(50) NOT NULL,		-- 비밀번호를 빈칸으로 해서 db에 저장하는걸 막는다.
	NAME VARCHAR2(50) NOT NULL,		-- ""
	EMAIL VARCHAR2(50) UNIQUE,		-- 중복은 불가능하지만 NULL 은 가능 -- 사용자 입력
	AUTH NUMBER(1) NOT NULL			-- 사용자 입력은 이메일까찌 이거는 직접 입력해주는거다.

) 
 */
public class Member implements Serializable {

	private String id;
	private String pwd;
	private String name;
	private String email;	// 유니크키(사용할거)
	private int auth;		// 사용자:3 관리자:1 (만약에 관리자면 다른 view로)(사용자면 다른 view)

	public Member(String id, String pwd, String name, String email, int auth) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.auth = auth;
	}
	
	
	public Member() {
		
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getAuth() {
		return auth;
	}


	public void setAuth(int auth) {
		this.auth = auth;
	}


	@Override
	public String toString() {
		return "Member [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", auth=" + auth + "]";
	}


	
	
	
	
	
	
}







