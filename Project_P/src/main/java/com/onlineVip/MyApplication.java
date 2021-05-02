package com.onlineVip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
@SpringBootApplication(scanBasePackages = { "com.onlineVip" })
@EnableMongoRepositories 
@ComponentScan("com.onlineVip")
public class MyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
	
}
