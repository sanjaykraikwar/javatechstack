package com.javatechstack.repository;


import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.javatechstack.model.Coupon;

public interface CouponRepository extends CassandraRepository<Coupon, UUID> {
	


}
