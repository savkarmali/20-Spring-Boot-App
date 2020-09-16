package com.example.SpringBootRestAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableJpaAuditing
public class SpringBootRestApiApplication extends SpringBootServletInitializer
{

	  @Override protected SpringApplicationBuilder
	  configure(SpringApplicationBuilder builder) {  
		  return builder.sources(SpringBootRestApiApplication.class); 
		  
	  }
	  
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiApplication.class, args);
	
		/*
		 * int a=5; System.out.println(a++); System.out.println(++a);
		 * System.out.println(a);
		 */
	}
	
	  @RequestMapping("/") public String hello() {
		 return "HIS-134"; 
	 }
	 
	
	  @RequestMapping("/") public String hello() { return
	  "Hello World From Tomcate"; }
	 

}
