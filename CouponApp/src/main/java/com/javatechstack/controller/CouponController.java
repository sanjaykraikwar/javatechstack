package com.javatechstack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechstack.model.Coupon;
import com.javatechstack.repository.CouponRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class CouponController {

	static Logger logger = LoggerFactory.getLogger(CouponController.class);

	@Autowired
	private CouponRepository couponRepository;

	
	// -------------------Create a Coupon--------------------------------------------------------
	
	@CrossOrigin(origins = "*")
	@PostMapping(value = "/coupon", headers = "Accept=application/json", produces = "application/json")
	public ResponseEntity<Coupon> saveCoupon(@RequestBody Coupon coupon) {

		System.out.println("Inside Save Coupon Service ");

		coupon.setId(UUID.randomUUID());

		Coupon newCoupon = couponRepository.save(coupon);

		logger.info("Coupon Saved");

		return new ResponseEntity(newCoupon, HttpStatus.CREATED);
	}
	
	
	// -------------------Retrieve all Coupons --------------------------------------------------------

		@GetMapping(value = "/coupon/all", headers = "Accept=application/json", produces = "application/json")
		@HystrixCommand(fallbackMethod = "getDefaultCouponsList")
		public ResponseEntity<List<Coupon>> getAllCoupons() {

			System.out.println("Inside Get All Coupon Service ");

			Iterable<Coupon> coupons = couponRepository.findAll();
			
			throw new RuntimeException("some exception");
			
			
			/*if (coupons == null) {
				logger.info("Coupons not found");
				return new ResponseEntity(HttpStatus.NOT_FOUND);
				

			} else {
				
				logger.info("all Coupon retrieved");

				List<Coupon> listCoupons = IteratorUtils.toList(coupons.iterator());

				return new ResponseEntity(listCoupons, HttpStatus.OK);
			}*/

		}
		
		
		public ResponseEntity<List<Coupon>> getDefaultCouponsList(){
			
			System.out.println("Inside fallback method ");
			
			Coupon coupon= new Coupon();
			coupon.setId(UUID.randomUUID());
			coupon.setValue(50);
			coupon.setCouponTitle("default");
			coupon.setCouponDescription("default coupon");
			List<Coupon> listCoupons =new ArrayList<>();
			listCoupons.add(coupon);
			System.out.println("Inside fallback method before return ");
			return new ResponseEntity(listCoupons, HttpStatus.OK);
		}
		

	// -------------------Retrieve Coupon based on Id--------------------------------------------------------

	@GetMapping(value = "/coupon/{id}", headers = "Accept=application/json", produces = "application/json")
	@CrossOrigin(origins = "*")
	public ResponseEntity<Coupon> getCoupon(@PathVariable("id") UUID id) {

		logger.info("Inside Get Coupon Service id=", id);

		Optional<Coupon> coupon = couponRepository.findById(id);

		if (!coupon.isPresent()) {
			logger.info("Coupon with id ", id, " not found");
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		logger.info("Coupon retrieved");

		return new ResponseEntity(coupon, HttpStatus.OK);
	}
	

	// ------------------- Update a coupon--------------------------------------------------------
	@CrossOrigin(origins = "*")
	@PutMapping(value = "/coupon/{id}", headers = "Accept=application/json", produces = "application/json")
	public ResponseEntity<Coupon> updateCoupon(@PathVariable("id") UUID id, @RequestBody Coupon coupon) {

		logger.info("Inside Update Coupon Service ");

		
		
		Optional<Coupon> optionalCoupon = couponRepository.findById(id);
		
		
		Coupon newCoupon=null;
		
		if(optionalCoupon.isPresent())
			newCoupon=optionalCoupon.get();

			if (coupon.getCouponTitle() != null)
				newCoupon.setCouponTitle(coupon.getCouponTitle());
			if (coupon.getCouponDescription() != null)
				newCoupon.setCouponDescription(coupon.getCouponDescription());
			if (coupon.getValue() != null)
				newCoupon.setValue(coupon.getValue());
			
	
			
			newCoupon = couponRepository.save(newCoupon);
		

		logger.info("Coupon Successfully Updated ");

		return new ResponseEntity(newCoupon, HttpStatus.OK);
	}

	// ------------------- Delete a coupon --------------------------------------------------------
	@CrossOrigin(origins = "*")
	@DeleteMapping("/coupon/{id}")
	public String deleteCoupon(@PathVariable("id") UUID id) {
		logger.info("Inside Delete Coupon Service ");

		couponRepository.deleteById(id);
		logger.info("Coupon Successfully Deleted");
		return "Coupon Successfully Deleted";
	}

}
