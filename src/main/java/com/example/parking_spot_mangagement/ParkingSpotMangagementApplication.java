package com.example.parking_spot_mangagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.qpa.controller, com.qpa.service, com.qpa.repository, com.qpa.exception")
@EntityScan("com.qpa.entity")
@EnableJpaRepositories("com.qpa.repository")
public class ParkingSpotMangagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingSpotMangagementApplication.class, args);
	}

}
