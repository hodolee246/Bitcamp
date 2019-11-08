package com.hello.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan
@Configuration
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class VoteSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoteSampleApplication.class, args);
	}

	 @Bean
	    public InternalResourceViewResolver setupViewResolver() {
	 
	        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	 
	        resolver.setPrefix("/WEB-INF/view/");
	        resolver.setSuffix(".jsp");
	        return resolver;
	    }



	
}
