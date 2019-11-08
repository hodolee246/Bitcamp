package com.hello.boot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MemberDto {

	private String id;
	private String pwd;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(String id, String pwd) {
		super();
		this.id = id;
		this.pwd = pwd;
	}
	
	
	
}
