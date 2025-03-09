package com.garagem.garagem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = "com.garagem")
@EntityScan(basePackages = {"com.garagem.domains", "com.garagem.domains.enums"})
@EnableJpaRepositories(basePackages = "com.garagem.repositories")
@SpringBootApplication

public class GaragemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GaragemApplication.class, args);
	}

}
