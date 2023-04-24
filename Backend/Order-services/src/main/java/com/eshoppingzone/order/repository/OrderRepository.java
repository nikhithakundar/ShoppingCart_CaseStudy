package com.eshoppingzone.order.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eshoppingzone.order.entity.Cart;
import com.eshoppingzone.order.entity.Orders;

@Repository
public interface OrderRepository extends MongoRepository<Orders, Integer>{

	List<Orders> findByCustomerId(int customerId);
	List<Orders> findByOrderId(int orderId);

	
	
}
