package com.frizerii.protorype;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProtorypeApplication {

	public static void main(String[] args) {
		System.out.println("[App initializing...]");
		SpringApplication.run(ProtorypeApplication.class, args);
		System.out.println("[App started...]");
	}

}
