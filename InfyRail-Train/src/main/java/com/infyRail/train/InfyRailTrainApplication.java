package com.infyRail.train;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "classpath:ValidationMessages.properties","classpath:application.properties"})
public class InfyRailTrainApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyRailTrainApplication.class, args);
	}

}
