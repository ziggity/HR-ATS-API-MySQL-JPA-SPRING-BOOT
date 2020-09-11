package com.promineo.hrtool;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class HrToolApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrToolApplication.class, args);
	}

}
