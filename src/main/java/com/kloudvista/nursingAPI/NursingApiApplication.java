package com.kloudvista.nursingAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class NursingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NursingApiApplication.class, args);

		System.out.println("My first spring boot application");
	}

}
