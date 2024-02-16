package com.olimpus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan({ "com.olimpus" })
@EnableJpaRepositories("com.olimpus")
@EntityScan("com.olimpus")
@EnableWebMvc
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
