package com.infyRail.configServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class InfyRailConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfyRailConfigServerApplication.class, args);
	}

}
