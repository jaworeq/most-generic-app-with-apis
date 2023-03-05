package com.example.mostgenericappwithapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MostGenericAppWithApisApplication {


	@Value("#${spring.datasource.url}")
	private static String var;
	public static void main(String[] args) {
		SpringApplication.run(MostGenericAppWithApisApplication.class, args);
	}

}
