package com.freelancerSmartProposal.SmartProposal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class SmartProposalApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartProposalApplication.class, args);
    }

}
