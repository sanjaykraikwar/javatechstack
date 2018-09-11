package com.javatechstack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.*;



@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication

public class CouponApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouponApplication.class, args);
	}
	
	
	public ProbabilityBasedSampler defaultSampler(){
		return new ProbabilityBasedSampler();
	}
}
