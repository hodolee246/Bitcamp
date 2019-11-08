package com.hello.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurituyConfig extends WebSecurityConfigurerAdapter{

	
	// 기본 메모리 내 인증 구성
	@Autowired
	public void configrueGlobal(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("admin")
		.password("admin").roles("admin");
	}


	

/*	
	  // http 보안을 활성화 하기 위한 기본 지원용 메소드 생성
	  
	  @Override protected void configure(HttpSecurity http) throws Exception {
	  http.authorizeRequests() .anyRequest().authenticated() .and().httpBasic(); }
*/	 
/*	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.anyRequest().authenticated()	//anyRequest 부분이 anyMatcheres("/login", "/login/*") 등으로 지정이 가능하다.
		.and().formLogin()
		.loginPage("/login").permitAll();
	}
	
*/	
	
	
	
	
}
