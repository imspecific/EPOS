package com.epos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class EposApplication {

	public static void main(String[] args) {
		SpringApplication.run(EposApplication.class, args);
		log.info("EPOS Application is running..");
	}

}
