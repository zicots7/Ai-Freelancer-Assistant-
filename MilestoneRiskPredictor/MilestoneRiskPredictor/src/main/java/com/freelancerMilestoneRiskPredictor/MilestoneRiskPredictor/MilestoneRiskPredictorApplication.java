package com.freelancerMilestoneRiskPredictor.MilestoneRiskPredictor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MilestoneRiskPredictorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MilestoneRiskPredictorApplication.class, args);
	}

}
