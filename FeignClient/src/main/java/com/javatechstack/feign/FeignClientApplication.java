package com.javatechstack.feign;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClientException;


import com.javatechstack.feign.controller.FeignClientController;

@EnableFeignClients
@SpringBootApplication
public class FeignClientApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(FeignClientApplication.class, args);
		FeignClientController feignClientController =ctx.getBean(FeignClientController.class);
		
		try {
			feignClientController.getCoupons();
		} catch (RestClientException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
		
		@Bean
		public  FeignClientController  feignClientController()
		{
			return  new FeignClientController();
		}
}
