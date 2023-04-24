package com.eshoppingzone.order.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eshoppingzone.order.entity.Address;
import com.eshoppingzone.order.entity.Cart;
import com.eshoppingzone.order.entity.Orders;
import com.eshoppingzone.order.exception.AddressNotFoundException;
import com.eshoppingzone.order.exception.OrdersNotFoundException;

@Service
public interface OrderService {
	
	public List<Orders> getAllOrders() throws OrdersNotFoundException;
	public List<Address> getAllAddress() throws AddressNotFoundException;
	public Orders getOrderByOrderId(int id) throws OrdersNotFoundException;
	public List<Address> getOrderByCustomerId(int id) throws AddressNotFoundException;
	public List<Orders> getOrdersByAddress(int id) throws OrdersNotFoundException;
	public Address storeAddress(Address address);
	public Orders changeOrderStatus(String status, int id);
	public String deleteOrder(int id) throws OrdersNotFoundException;
	public Orders placeorders(Orders order) throws OrdersNotFoundException;

	
	
}
