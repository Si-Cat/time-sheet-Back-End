package com.satge.satge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = "com.satge.satge")
public class SatgeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SatgeApplication.class, args);
		System.out.println("hello world");
		System.out.println("start cooking");
	}

}
