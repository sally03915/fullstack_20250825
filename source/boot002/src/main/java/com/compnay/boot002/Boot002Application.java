package com.compnay.boot002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.compnay.boot002.basic.Basic002_Dto;

@SpringBootApplication
public class Boot002Application {
	public static void main(String[] args) {
		//SpringApplication.run(Boot002Application.class, args);
		Basic002_Dto  dto = new Basic002_Dto();
		dto.setName("first");
		dto.setAge(10);
		System.out.println("...." + dto.getName() );
		System.out.println("...." + dto.getAge() );
	}
}
