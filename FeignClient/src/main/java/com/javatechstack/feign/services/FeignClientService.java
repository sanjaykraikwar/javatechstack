package com.javatechstack.feign.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="CouponApplication")
//@FeignClient(name="ZuulGatewayApplication")
public interface FeignClientService {
	
	@GetMapping(value="/coupon/all")
	//@GetMapping(value="/CouponApp/coupon/all")
	public String getCoupons();
}
