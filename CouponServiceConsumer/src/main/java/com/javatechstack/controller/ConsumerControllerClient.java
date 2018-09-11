package com.javatechstack.controller;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.javatechstack.FeignClientService;

@RestController
public class ConsumerControllerClient {
	
	//@Autowired
	//private DiscoveryClient discoveryClient;
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	@Autowired
	FeignClientService  feignClientService;
	
	
	@GetMapping("/coupons")
	public String getCoupon() throws RestClientException, IOException {
		
		//List<ServiceInstance> instances=discoveryClient.getInstances("CouponApplication");
		//ServiceInstance serviceInstance=instances.get(0);
		//ServiceInstance serviceInstance=loadBalancer.choose("CouponApplication");

		//String baseUrl=serviceInstance.getUri().toString()+"/coupon/all";
		
		//System.out.println("instance url:"+baseUrl);
		
	
		//String baseUrl = "http://localhost:8080/coupon/all";	
				
		/*RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange(baseUrl,
				HttpMethod.GET, getHeaders(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());*/
		
		System.out.println("feign client response"+feignClientService.getCoupons());
		
		return  feignClientService.getCoupons();
		
		
	}

	private static HttpEntity<?> getHeaders() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
	}


}
