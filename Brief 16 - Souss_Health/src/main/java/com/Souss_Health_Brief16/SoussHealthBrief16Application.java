package com.Souss_Health_Brief16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class SoussHealthBrief16Application {

	public static void main(String[] args) {
		SpringApplication.run(SoussHealthBrief16Application.class, args);
	}

}
