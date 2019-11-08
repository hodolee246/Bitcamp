package com.hello.boot.bean;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class KakaoPayReadyVO {

	//response
	private String tid, next_redirect_pc_url;
	private Date created_at;
	
}
