package com.eshoppingzone.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eshoppingzone.order.entity.Address;

@Repository
public interface AddressRepository extends MongoRepository<Address, Integer>{

	List<Address> findByCustomerId(Integer customerId);
	List<Address> findByFullName(String fullName);
}
