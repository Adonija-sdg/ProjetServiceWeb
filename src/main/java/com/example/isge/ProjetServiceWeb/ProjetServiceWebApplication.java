package com.example.isge.ProjetServiceWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ProjetServiceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetServiceWebApplication.class, args);
	}

}
