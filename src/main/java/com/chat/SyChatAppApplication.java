package com.chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@ComponentScan
//@EnableScheduling
//@EnableJpaRepositories(basePackages = "com.leeset.data.jpa.repository")
//@EntityScan(basePackages = "com.leeset.data.jpa.model")
@SpringBootApplication
public class SyChatAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyChatAppApplication.class, args);
	}
}
