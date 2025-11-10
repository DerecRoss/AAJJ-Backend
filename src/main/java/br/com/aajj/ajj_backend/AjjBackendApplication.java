package br.com.aajj.ajj_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class AjjBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjjBackendApplication.class, args);
	}

}
