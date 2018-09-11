package com.javatechstack.feign.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestClientException;

import com.javatechstack.feign.services.FeignClientService;

@Controller
public class FeignClientController {
	
	@Autowired
	private FeignClientService clientService;

	public void getCoupons() throws RestClientException, IOException {
		
		System.out.println("inside get coupons");

		try {
			
			String response = clientService.getCoupons();
			System.out.println(response);
			
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}


}
