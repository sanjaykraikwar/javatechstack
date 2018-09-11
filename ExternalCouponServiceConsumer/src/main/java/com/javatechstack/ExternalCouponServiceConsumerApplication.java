package com.javatechstack;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.javatechstack.controller.ExternalConsumerControllerClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ExternalCouponServiceConsumerApplication { 

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx=SpringApplication.run(ExternalCouponServiceConsumerApplication.class, args);
		
				
		ExternalConsumerControllerClient consumerControllerClient=ctx.getBean(ExternalConsumerControllerClient.class);
			
		consumerControllerClient.getCoupon();
			
		}
		
		@Bean
		public  ExternalConsumerControllerClient  externalConsumerControllerClient()
		{
			return  new ExternalConsumerControllerClient();
		}
	}

