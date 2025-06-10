package com.spring.microservices.inventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryServiceMain {
	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceMain.class,args);
	}
}
