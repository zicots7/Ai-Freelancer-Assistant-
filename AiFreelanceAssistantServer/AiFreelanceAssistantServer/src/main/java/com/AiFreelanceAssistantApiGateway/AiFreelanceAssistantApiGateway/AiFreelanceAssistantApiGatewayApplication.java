package com.AiFreelanceAssistantApiGateway.AiFreelanceAssistantApiGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class AiFreelanceAssistantApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AiFreelanceAssistantApiGatewayApplication.class, args);
	}

}
