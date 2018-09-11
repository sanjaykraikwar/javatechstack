package com.javatechstack;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;

import com.javatechstack.controller.ConsumerControllerClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CouponServiceConsumerApplication { 

	public static void main(String[] args) throws RestClientException, IOException {
		ApplicationContext ctx=SpringApplication.run(CouponServiceConsumerApplication.class, args);
		
				
		ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
			
		consumerControllerClient.getCoupon();
			
		}
		
		@Bean
		public  ConsumerControllerClient  consumerControllerClient()
		{
			return  new ConsumerControllerClient();
		}
	}

