package com.eshoppingzone.order;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;


import com.eshoppingzone.order.controller.OrderResource;
import com.eshoppingzone.order.entity.Address;
import com.eshoppingzone.order.entity.Cart;
import com.eshoppingzone.order.entity.ErrorResponse;
import com.eshoppingzone.order.entity.Items;
import com.eshoppingzone.order.entity.LoggerResponse;
import com.eshoppingzone.order.entity.Orders;
import com.eshoppingzone.order.entity.Product;
//import com.eshoppingzone.order.entity.User1;

import com.eshoppingzone.order.repository.AddressRepository;
import com.eshoppingzone.order.repository.OrderRepository;
import com.eshoppingzone.order.service.OrderServiceImpl;


@SpringBootTest
class OrderServiceTest {

	@Autowired
	OrderServiceImpl orderserviceimpl;

	@MockBean
	OrderRepository orderrepository;

	@MockBean
	AddressRepository addressRepository;

	@Autowired
	OrderResource orderResource;
	Orders order;
	List<Orders> orders = new ArrayList<>();

	@Test
	public void getAllOrders_test() {

		List<Orders> orders = new ArrayList<>();
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
		Address ad=new Address(3, "sam", "643734983", 44, "Bang", 34782, "KA");
		Orders o = new Orders();

		o.setOrderId(99);
		o.setOrderDate(LocalDate.now());
		o.setAmountPaid(1000.00);
		o.setModeOfPayment("Paytm");
		o.setOrderStatus("delivered");
		o.setQuantity(2);
		o.setProductId(44);
		o.setCustomerId(1);
		o.setAddress(ad);
		o.setCart(c);
		orders.add(o);

		when(orderrepository.findAll()).thenReturn(orders);
		assertEquals(1, orderserviceimpl.getAllOrders().size());
	}
	
	@Test
	public void getallOrderException_test() {
		List<Orders> products = new ArrayList<>();
		Orders o2 = new Orders();
		//products.add(o2);

		when(orderrepository.findAll()).thenReturn(products);
		assertEquals(1, orderserviceimpl.getAllOrders().size());
	}

	@Test
	public void getAddress_test() {
		List<Address> address = new ArrayList<>();
		Address a = new Address();
		a.setFullName("nikki");
		a.setCustomerId(55);
		a.setFlatNumber(99);
		a.setMobileNumber("674787234");
		a.setCity("Bang");
		a.setState("KA");
		a.setPincode(6478734);
		address.add(a);

		when(addressRepository.findAll()).thenReturn(address);
		assertEquals(1, orderserviceimpl.getAllAddress().size());
	}

	@Test
	public void getByOrderId_test() {
		Orders o = new Orders();
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
		Address ad=new Address(3, "sam", "643734983", 44, "Bang", 34782, "KA");
		o.setOrderId(11);
		o.setOrderDate(LocalDate.now());
		o.setAmountPaid(1000.00);
		o.setModeOfPayment("Paytm");
		o.setOrderStatus("delivered");
		o.setQuantity(2);
		o.setProductId(44);
		o.setCustomerId(1);
		o.setAddress(ad);
		o.setCart(c);

		Optional<Orders> byorderid = Optional.of(o);
		when(orderrepository.findById(11)).thenReturn(byorderid);
		assertEquals(o, orderserviceimpl.getOrderByOrderId(11));

	}
	
	@Test
	public void getByOrderIdException_test() {
		Orders o = new Orders();
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
		Address ad=new Address(3, "sam", "643734983", 44, "Bang", 34782, "KA");

		o.setOrderId(11);
		o.setOrderDate(LocalDate.now());
		o.setAmountPaid(1000.00);
		o.setModeOfPayment("Paytm");
		o.setOrderStatus("delivered");
		o.setQuantity(2);
		o.setProductId(44);
		o.setCustomerId(1);
		o.setAddress(ad);
		o.setCart(c);

		Optional<Orders> byorderid = Optional.of(o);
		when(orderrepository.findById(11)).thenReturn(byorderid);
		assertEquals(o, orderserviceimpl.getOrderByOrderId(10));

	}
	

	@Test
	public void placeorder_test() {
		Orders o = new Orders();
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
		Address ad=new Address(3, "sam", "643734983", 44, "Bang", 34782, "KA");

		o.setOrderId(11);
		o.setOrderDate(LocalDate.now());
		o.setAmountPaid(1000.00);
		o.setModeOfPayment("Paytm");
		o.setOrderStatus("delivered");
		o.setQuantity(2);
		o.setProductId(44);
		o.setCustomerId(1);
		o.setAddress(ad);
		o.setCart(c);

		when(orderrepository.insert(o)).thenReturn(o);
		assertEquals(o, orderserviceimpl.placeorders(o));
	}

	
	@Test
	public void deleteOrder_test() {
		Orders o = new Orders();
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
		Address ad=new Address(3, "sam", "643734983", 44, "Bang", 34782, "KA");
		o.setOrderId(13);
		o.setOrderDate(LocalDate.now());
		o.setAmountPaid(6000.00);
		o.setModeOfPayment("Paytm");
		o.setOrderStatus("confirmed");
		o.setQuantity(1);
		o.setProductId(47);
		o.setCustomerId(2);
		o.setAddress(ad);
		o.setCart(c);

		Optional<Orders> orderDelete = Optional.of(o);
		when(orderrepository.findById(13)).thenReturn(orderDelete);
		assertEquals("Deleted Sucessfully",orderserviceimpl.deleteOrder(13));
	}
	@Test
    public void deleteOrderException_test() {
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
        Address ad = new Address(10, "Nikki", "1234567890", 201, "cbe", 641659, "TN");
        Orders o = new Orders();
        o.setOrderId(10);
        o.setOrderDate(LocalDate.now());
        o.setModeOfPayment("Razor");
        o.setAmountPaid(120.0);
        o.setOrderStatus("completed");
        o.setProductId(122);
        o.setAddress(ad);
    	o.setCart(c);


        Optional<Orders> delete = Optional.of(o);
        when(orderrepository.findById(10)).thenReturn(delete);
        assertEquals("Deleted successfully", orderserviceimpl.deleteOrder(11));
    }
	
	
	@Test
	public void storeAddress_test() {
		
		Address a = new Address();
		a.setFullName("Sampu");
		a.setCustomerId(57);
		a.setFlatNumber(98);
		a.setMobileNumber("784378892");
		a.setCity("Bang");
		a.setState("KA");
		a.setPincode(6478734);
		
		
		when(addressRepository.insert(a)).thenReturn(a);
		assertEquals(a,orderserviceimpl.storeAddress(a));
	}
	
	
	
	 @Test
	    public void orderIdByCustomer_test() {
	        Address a = new Address();
	        a.setFullName("Nikki");
	        a.setCustomerId(100);
	        a.setFlatNumber(201);
	        a.setMobileNumber("1234567890");
	        a.setCity("coimbatore");
	        a.setState("TN");
	        a.setPincode(651546);


	        List<Address> byidtest = List.of(a);
	        when(addressRepository.findByCustomerId(100)).thenReturn(byidtest);
	        assertEquals(byidtest, orderserviceimpl.getOrderByCustomerId(100));
	    }
	 
	 @Test
	    public void orderIdByCustomerException_test() {
	        Address a = new Address();
	        a.setFullName("Madhu");
	        a.setCustomerId(100);
	        a.setFlatNumber(201);
	        a.setMobileNumber("1234567890");
	        a.setCity("coimbatore");
	        a.setState("TN");
	        a.setPincode(651546);

	
	        List<Address> byidtest = List.of(a);
	        when(addressRepository.findByCustomerId(100)).thenReturn(byidtest);
	        assertEquals(byidtest, orderserviceimpl.getOrderByCustomerId(10));
	    }
	 
	@Test
	public void changeOrder_test() {
		Orders o = new Orders();
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
		Address ad=new Address(3, "sam", "643734983", 44, "Bang", 34782, "KA");
		o.setOrderId(11);
		o.setOrderDate(LocalDate.now());
		o.setAmountPaid(1000.00);
		o.setModeOfPayment("Paytm");
		o.setOrderStatus("delivered");
		o.setQuantity(2);
		o.setProductId(44);
		o.setCustomerId(1);
		o.setAddress(ad);
		o.setCart(c);
		Optional<Orders> byorderid = Optional.of(o);
		when(orderrepository.findById(11)).thenReturn(byorderid);
		assertEquals(o, orderserviceimpl.changeOrderStatus("Delivered", 11));

	}
	
	
	@Test
    public void getOrdersByCustomerId_test() {
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);

        Address ad = new Address(10, "Nikki", "1234567890", 201, "cbe", 641659, "TN");
        Orders o = new Orders();
        o.setOrderId(10);
        o.setCustomerId(100);
        o.setOrderDate(LocalDate.now());
        o.setModeOfPayment("Razor");
        o.setAmountPaid(120.0);
        o.setOrderStatus("completed");
        o.setProductId(122);
        o.setAddress(ad);
       o.setCart(c);


        List<Orders> bycus = List.of(o);
        when(orderrepository.findByCustomerId(100)).thenReturn(bycus);
        assertEquals(bycus, orderserviceimpl.getOrdersByAddress(100));

    }
	
	 @Test
	    public void getOrdersByCustomerIdException_test() {
		 Product p=new Product(111, "Soap");
			Cart c=new Cart(11, 100.0, p);
	        Address ad = new Address(10, "Nikki", "1234567890", 201, "cbe", 641659, "TN");
	        Orders o = new Orders();
	        o.setOrderId(10);
	        o.setCustomerId(100);
	        o.setOrderDate(LocalDate.now());
	        o.setModeOfPayment("Razor");
	        o.setAmountPaid(120.0);
	        o.setOrderStatus("completed");
	        o.setProductId(122);
	        o.setAddress(ad);
	        o.setCart(c);

	        List<Orders> bycus = List.of(o);
	        when(orderrepository.findByCustomerId(100)).thenReturn(bycus);
	        assertEquals(bycus, orderserviceimpl.getOrdersByAddress(101));


	    }

	 

 
	
	@Test
	public void loggerResponse_test() {
		
		LoggerResponse l=new LoggerResponse();
		l.setMessage("Not null");
	}
	
	
	@Test
	public void loggerResponses_test() {
		LoggerResponse l=new LoggerResponse("Not Null");
		l.setMessage("not null");
	}
	
	@Test
	public void ErrorResponse_test() {
		ErrorResponse e=new ErrorResponse();
		e.setStatusmessage(HttpStatus.OK);
		e.setDatetime(LocalDateTime.now());
		e.setMessage("not null");
	}
	@Test
	public void ErrorResponses_test() {
		ErrorResponse e=new ErrorResponse(HttpStatus.OK, "Not null", LocalDateTime.now());
		e.setStatusmessage(HttpStatus.OK);
		e.setDatetime(LocalDateTime.now());
		e.setMessage("not null");
	}
	@Test
	public void productTest() {
		Product p=new Product();
		p.setProductId(1);
		p.setProductName("Saree");
	}
	
	
	@Test
	public void productTests() {
		Product p=new Product(1, "Product");
		p.setProductId(1);
		p.setProductName("Soap");
	}
	
	@Test
	public void ItemTest() {
		Items i=new Items();
		i.setPrice(100.0);
		i.setProductName("Soap");
		i.setQuantity(10);
	}
	@Test
	public void ItemTests() {
		Items i=new Items("jean", 20.0, 3);
		i.setPrice(20.0);
		i.setProductName("jean");
		i.setQuantity(3);
	}
	
	
	
	@Test
	public void orderConstructot_test() {
		
		Product p=new Product(111, "Soap");
		Cart c=new Cart(11, 100.0, p);
		Address ad=new Address(3, "sam", "643734983", 44, "Bang", 34782, "KA");
		Orders o1=new Orders(1, LocalDate.now(), 4, 10.0, "paytm", "confirmed", 3, ad, c, 1);
		o1.setAmountPaid(60.00);
		o1.setCustomerId(1);
		o1.setAddress(ad);
		o1.setCart(c);
		o1.setModeOfPayment("paytm");
		o1.setOrderDate(LocalDate.now());
		o1.setOrderId(1);
		o1.setOrderStatus("completed");
		o1.setProductId(11);
		o1.setQuantity(2);
		
			
	}
	@Test
	public void defaultOrderConstructor_test() {
		Orders o1=new Orders();
		Address ad=new Address();
		Product p=new Product();
		Cart c=new Cart();
		o1.setAmountPaid(60.00);
		o1.setCustomerId(1);
		o1.setAddress(ad);
		o1.setCart(c);
		o1.setModeOfPayment("paytm");
		o1.setOrderDate(LocalDate.now());
		o1.setOrderId(1);
		o1.setOrderStatus("completed");
		o1.setProductId(11);
		o1.setQuantity(2);
	}
	
	
	
}
