package com.eshoppingzone.order.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.order.entity.Address;
import com.eshoppingzone.order.entity.LoggerResponse;
import com.eshoppingzone.order.entity.Orders;

import com.eshoppingzone.order.exception.AddressNotFoundException;
import com.eshoppingzone.order.exception.OrdersNotFoundException;
import com.eshoppingzone.order.repository.AddressRepository;

import com.eshoppingzone.order.service.OrderService;


@RestController
@CrossOrigin()
@RequestMapping("/order")
public class OrderResource {
	
	@Autowired
	OrderService orderservice;
	
	@Autowired
	AddressRepository addressrepository;

	
	Logger logger = LoggerFactory.getLogger(LoggerResponse.class);
	
	@GetMapping("/allorders")
	public ResponseEntity<List<Orders>> getAllOrders() throws OrdersNotFoundException{
		logger.error("Retrived all the Orders ");
		return  ResponseEntity.ok(orderservice.getAllOrders());
	}
	
	
	@GetMapping("/alladdress")
	public ResponseEntity<List<Address>> getAllAddress() throws AddressNotFoundException{
		logger.error("Retrived all the Address ");
		return ResponseEntity.ok(orderservice.getAllAddress());
	}
	
	@GetMapping("/getorderbyid/{id}")
	public  ResponseEntity<Orders> getOrderByOrderId(@PathVariable int id) throws OrdersNotFoundException{
		logger.error("Retrived the Orders by id ");
		return ResponseEntity.ok(orderservice.getOrderByOrderId(id));
	}
	
	@GetMapping("/getorderbyaddress/{id}")
	public ResponseEntity<List<Address>> getOrderByCustomerId(@PathVariable int id) throws AddressNotFoundException {
		logger.error("Retrived the Orders by using the address");
		return ResponseEntity.ok(orderservice.getOrderByCustomerId(id));
	}
	
	@GetMapping("/getorderbycustomerid/{id}")
	public ResponseEntity<List<Orders>> getOrdersByAddress(@PathVariable int id) throws OrdersNotFoundException{
		logger.error("Retrived all the Orders using customer id");
		return ResponseEntity.ok(orderservice.getOrdersByAddress(id));
	}
	
	@PostMapping("/placeorder")
	public ResponseEntity<Orders> placeorders(@Valid @RequestBody Orders order) throws OrdersNotFoundException {
		logger.info("Placing order method got executed");
		return ResponseEntity.ok(orderservice.placeorders(order));
	}
	
	@PostMapping("/storeaddress")
	public ResponseEntity<Address> storeAddress(@Valid @RequestBody Address address) {
		logger.error("Stored the address for Orders ");
		return ResponseEntity.ok(orderservice.storeAddress(address));
	}
	
	@PutMapping("/changeorder/{status}/{id}")
	public ResponseEntity<Orders> changeOrderStatus(@PathVariable String status,@PathVariable int id) {
		logger.error("Changed the Order status for the order that matches the id ");
		return ResponseEntity.ok(orderservice.changeOrderStatus(status,id));
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteOrder(@PathVariable int id)throws OrdersNotFoundException {
		logger.error("Deleted the order which matches the orderid ");
		orderservice.deleteOrder(id);
	}
}
