package com.nci.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableAutoConfiguration
public class EmailSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailSpringBootApplication.class, args);
	}

}
