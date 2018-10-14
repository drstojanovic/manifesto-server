package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.manifesto.amqp.MessagingService;

@SpringBootApplication
@ComponentScan(basePackages= {"com.manifesto.*"})
@EntityScan(basePackages= {"com.manifesto.*"})
@EnableJpaRepositories(basePackages= {"com.manifesto.*"})
public class ManifestoApplication {

	public static void main(String[] args) {
		MessagingService.getInstance();
		SpringApplication.run(ManifestoApplication.class, args);
		//kad zatvoriti konekciju i kanal?
	}
}
