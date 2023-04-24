package com.eshoppingzone.order.service;


import java.util.List;
import java.util.Optional;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.eshoppingzone.order.entity.Address;
import com.eshoppingzone.order.entity.Orders;
import com.eshoppingzone.order.exception.AddressNotFoundException;
import com.eshoppingzone.order.exception.OrdersNotFoundException;
import com.eshoppingzone.order.repository.AddressRepository;
import com.eshoppingzone.order.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	  @Autowired 
	  OrderRepository orderrepository;
	  
	  @Autowired 
	  AddressRepository addressrepository;
	  
	 Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	 public List<Orders> getAllOrders() throws OrdersNotFoundException {
		List<Orders> findAll = orderrepository.findAll();
        logger.info("GetAllOrders method started");
		if(!findAll.isEmpty()) {
			logger.info("If condition for getallorders method is started");
			//logger.debug("Order are:{}",findAll);
		   return orderrepository.findAll();
		}
		else {
			logger.info("Else condition for getallorders method is executed");
			throw new OrdersNotFoundException("No datas found");
		}
		
	}
	

	public List<Address> getAllAddress() throws AddressNotFoundException {
		List<Address> findAll = addressrepository.findAll();
		logger.info("GetAllAddress method started");
		if(!findAll.isEmpty()) {
			 logger.info("If condition for getalladdress method is executed");
		    return addressrepository.findAll();
		}
		else {
			 logger.info("Else condition for getalladdress method is executed");
			throw new AddressNotFoundException("No datas found");
		}
	}

	public Orders getOrderByOrderId(int id) throws OrdersNotFoundException{
		Optional<Orders> findById = orderrepository.findById(id);
		logger.info("GetOrderByOrderId method is started");
		if(findById.isPresent()) {
			logger.info("If condition for GetOrderByOrderId method is executed");
		    return findById.get();
		}
		else {
			logger.info("Else condition for GetOrderByOrderId method is executed");
			throw new OrdersNotFoundException(id+" Does Not Exists");
		}
	}

	public List<Address> getOrderByCustomerId(int id) throws AddressNotFoundException {
		List<Address> findById = addressrepository.findByCustomerId(id);
		logger.info("GetOrderByCustomerId method is started");
		if(!findById.isEmpty()) {
			logger.info("If condition for GetOrderByCustomerId method is executed");
			return addressrepository.findByCustomerId(id);
		}
		else {
			logger.info("Else condition for GetOrderByCustomerId method is executed");
			throw new AddressNotFoundException(id+" Does Not Exists");
		}
		
	}

	public List<Orders> getOrdersByAddress(int id) throws OrdersNotFoundException {
		List<Orders> findByCustomerId = orderrepository.findByCustomerId(id);
		logger.info("GetOrdersByAddress method is started");
		if(!findByCustomerId.isEmpty()) {
			logger.info("If condition for GetOrdersByAddress method is executed");
			return orderrepository.findByCustomerId(id);
		}
		else {
			logger.info("Else condition for GetOrdersByAddress method is executed");
			throw new OrdersNotFoundException(id+" Does Not Exists");
		}
	}

	@Override
	public Address storeAddress(Address address) {
		List<Address> findByCustomerId = addressrepository.findByCustomerId(address.getCustomerId());
		logger.info("StoreAddress method is started");
		if(findByCustomerId.isEmpty()) {
			logger.info("If condition for StoreAddress method is executed");
		    return addressrepository.save(address);	
		}
		else {
			logger.info("Else condition for StoreAddress method is executed");
			throw new AddressNotFoundException(address.getCustomerId()+" Already exists");
		}
	}

	@Override
	public Orders changeOrderStatus(String status, int id) {
		List<Orders> findByOrderId = orderrepository.findByOrderId(id);
		logger.info("ChangeOrderStatus method is started");
		if(!findByOrderId.isEmpty()) {
			logger.info("If condition for ChangeOrderStatus method is executed");
		    Orders order = orderrepository.findById(id).orElseThrow();
		    order.setOrderStatus(status);
		    return order;
		}
		else {
			logger.info("Else condition for ChangeOrderStatus method is executed");
			throw new OrdersNotFoundException("Invalid Id status cannot be changed");
		}
		
	}

	@Override
	public String deleteOrder(int id) throws OrdersNotFoundException {
		Optional<Orders> findById = orderrepository.findById(id);
		logger.info("DeleteOrder method is started");
		if(findById.isPresent()) {
			logger.info("If condition for DeleteOrder method is executed");
		    orderrepository.deleteById(id);
		    return "Deleted Sucessfully";
		    
		}
		else {
			logger.info("Else condition for DeleteOrder method is executed");
			throw new OrdersNotFoundException(id+" Already been deleted or not been present");
		}
		
	}

	@Override
	public Orders placeorders(Orders order) {
		List<Orders> findById = orderrepository.findByOrderId(order.getOrderId());
		logger.info("Placeorders method is started");
		if(findById.isEmpty()) {
			logger.info("If condition for Placeorders method is executed");
		    return orderrepository.insert(order);
		}
		else {
			logger.info("Else condition for Placeorders method is executed");
			throw new OrdersNotFoundException("Order is already placed on this id");
		}
	}


	
}
