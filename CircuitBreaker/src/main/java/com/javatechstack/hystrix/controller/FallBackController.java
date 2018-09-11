package com.javatechstack.hystrix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechstack.hystrix.model.Coupon;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class FallBackController {
	
	@GetMapping(value = "/coupon/all")
	@HystrixCommand(fallbackMethod = "getDefaultCoupon")
 public Coupon getDefaultCoupon(){
		
		Coupon coupon= new Coupon();
		coupon.setValue(50);
		coupon.setCouponTitle("default");
		coupon.setCouponDescription("default coupon");
		return coupon;
	}
	
	

}
