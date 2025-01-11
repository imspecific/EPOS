package com.epos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EposApplication {

	public static void main(String[] args) {
		SpringApplication.run(EposApplication.class, args);
		System.out.println("EPOS Application is running..");
	}

}
