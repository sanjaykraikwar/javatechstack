package com.javatechstack;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;


@FeignClient(name="CouponApplication",value="CouponApplication")
public interface FeignClientService {
	
	@GetMapping(value="/coupon/all")
	public String getCoupons();
}
