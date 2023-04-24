package com.eshoppingzone.produt;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.eshoppingzone.produt.productservice.entity.ErrorResponse;
import com.eshoppingzone.produt.productservice.entity.LoggerResponse;
import com.eshoppingzone.produt.productservice.entity.Product;
import com.eshoppingzone.produt.productservice.repository.ProductRepository;

import com.eshoppingzone.produt.productservice.service.ProductServiceImpl;

@SpringBootTest
class ProductServiceTest {


	@Autowired
	private ProductServiceImpl productServiceImpl;
	@MockBean
	private ProductRepository productrepository;

	@Test
	public void getallproduct_test() {
		List<Product> products = new ArrayList<>();
		Product p = new Product();

		p.setProductId(14);
		p.setProductName("Pen");
		p.setProductType("Sationary");
		p.setCategory("Book");
		p.setDescription("Point pen");
		p.setPrice(5.0);
		p.setRating("3.3");
		p.setImage("img1.jpg");
		p.setReview("Good");
		p.setSpecification("for all");

		products.add(p);

		when(productrepository.findAll()).thenReturn(products);
		assertEquals(1, productServiceImpl.getAllProduct().size());
	}

	@Test
	public void ProductById_test() {

		Product p = new Product();

		p.setProductId(14);
		p.setProductName("Pen");
		p.setProductType("Sationary");
		p.setCategory("Book");
		p.setDescription("Point pen");
		p.setPrice(5.0);
		p.setRating("3.3");
		p.setImage("img2.jpg");
		p.setReview("Good");
		p.setSpecification("for all");

		Optional<Product> byproductid = Optional.of(p);
		when(productrepository.findById(14)).thenReturn(byproductid);
		assertEquals(p, productServiceImpl.getProductById(14));

	}

	@Test
	public void addProduct_test() {

		Product p = new Product();

		p.setProductId(14);
		p.setProductName("Pen");
		p.setProductType("Sationary");
		p.setCategory("Book");
		p.setDescription("Point pen");
		p.setPrice(5.0);
		p.setRating("3.3");
		p.setImage("img1.jpg");
		p.setReview("Good");
		p.setSpecification("for all");

		when(productrepository.insert(p)).thenReturn(p);
		assertEquals(p, productServiceImpl.addProduct(p));

	}
	

	@Test
	public void getProductByName_test() {
		
		Product p3 = new Product();

		p3.setProductId(14);
		p3.setProductName("Pen");
		p3.setProductType("Sationary");
		p3.setCategory("Book");
		p3.setDescription("Point pen");
		p3.setPrice(5.0);
		p3.setRating("3.3");
		p3.setImage("img2.jpg");
		p3.setReview("Good");
		p3.setSpecification("for all");

		List<Product> byproductname = List.of(p3);
		when(productrepository.findByProductName("Pen")).thenReturn(byproductname);
		assertEquals(byproductname, productServiceImpl.getProductByName("Pen"));
		
	}
	
	@Test
	public void getProductByNameException_test() {
		
		Product p3 = new Product();

		p3.setProductId(14);
		p3.setProductName("Pen");
		p3.setProductType("Sationary");
		p3.setCategory("Book");
		p3.setDescription("Point pen");
		p3.setPrice(5.0);
		p3.setRating("3.3");
		p3.setImage("img2.jpg");
		p3.setReview("Good");
		p3.setSpecification("for all");

		List<Product> byproductname = List.of(p3);
		when(productrepository.findByProductName("Pen")).thenReturn(byproductname);
		assertEquals(byproductname, productServiceImpl.getProductByName("Pen"));
	}
	@Test
	public void getProductByCategory_test() {
		Product p4 = new Product();

		p4.setProductId(14);
		p4.setProductName("Pen");
		p4.setProductType("Sationary");
		p4.setCategory("Book");
		p4.setDescription("Point pen");
		p4.setPrice(5.0);
		p4.setRating("3.3");
		p4.setImage("img2.jpg");
		p4.setReview("Good");
		p4.setSpecification("for all");

		List<Product> byproductcategory = List.of(p4);
		when(productrepository.findByCategory("Book")).thenReturn(byproductcategory);
		assertEquals(byproductcategory, productServiceImpl.getProductByCategory("Book"));
		
	}
	
	@Test
	public void getProductByCategoryException_test() {
		
		Product p4 = new Product();

		p4.setProductId(14);
		p4.setProductName("Pen");
		p4.setProductType("Sationary");
		p4.setCategory("Book");
		p4.setDescription("Point pen");
		p4.setPrice(5.0);
		p4.setRating("3.3");
		p4.setImage("img2.jpg");
		p4.setReview("Good");
		p4.setSpecification("for all");

		List<Product> byproductcategory = List.of(p4);
		when(productrepository.findByCategory("Book")).thenReturn(byproductcategory);
		assertEquals(byproductcategory, productServiceImpl.getProductByCategory("Book"));
	}
	
	@Test
	public void getProductByType_test() {
		
		Product p4 = new Product();

		p4.setProductId(14);
		p4.setProductName("Pen");
		p4.setProductType("Sationary");
		p4.setCategory("Book");
		p4.setDescription("Point pen");
		p4.setPrice(5.0);
		p4.setRating("3.3");
		p4.setImage("img2.jpg");
		p4.setReview("Good");
		p4.setSpecification("for all");

		List<Product> byproducttype = List.of(p4);
		when(productrepository.findByProductType("Sationary")).thenReturn(byproducttype);
		assertEquals(byproducttype, productServiceImpl.getProductByType("Sationary"));
	}
	
	@Test
	public void getProductByTypeException_test() {
		
		Product p4 = new Product();

		p4.setProductId(14);
		p4.setProductName("Pen");
		p4.setProductType("Sationary");
		p4.setCategory("Book");
		p4.setDescription("Point pen");
		p4.setPrice(5.0);
		p4.setRating("3.3");
		p4.setImage("img2.jpg");
		p4.setReview("Good");
		p4.setSpecification("for all");

		List<Product> byproducttype = List.of(p4);
		when(productrepository.findByProductType("Sationary")).thenReturn(byproducttype);
		assertEquals(byproducttype, productServiceImpl.getProductByType("Sationary"));
	}

	@Test
	public void errorResponse_test() {
		ErrorResponse e=new ErrorResponse();
		
		e.setMessage("NOT NULL");
		e.setStatusmessage(null);
		e.setDatetime(LocalDateTime.now());
		
	}
	
	@Test
	public void errorResponses_test() {
		
		ErrorResponse e1=new ErrorResponse(HttpStatus.OK,"NOT NULL",LocalDateTime.now());
		e1.setMessage("NOT NULL");
		e1.setStatusmessage(HttpStatus.OK);
		e1.setDatetime(LocalDateTime.now());
		
	}
	
	@Test
	public void LoggerResponse_test() {
		LoggerResponse l=new LoggerResponse();
		l.setMessage("NOT FOUND");
		
	}
	
	@Test
	public void LoggerResponses_test() {
		LoggerResponse l=new LoggerResponse("Not Found");
		l.setMessage("NOt Null");
		l.getMessage();
	}
	
	@Test
	public void productConstructor_test() {
		Product p4=new Product(1,"Clothing","Jeans","Aparel","3.3", "Good", "img", 200.0,"cotton", "all");
		
		p4.setProductId(14);
		p4.setProductName("Pen");
		p4.setProductType("Sationary");
		p4.setCategory("Book");
		p4.setDescription("Point pen");
		p4.setPrice(5.0);
		p4.setRating("3.3");
		p4.setImage("img2.jpg");
		p4.setReview("Good");
		p4.setSpecification("for all");
	}
	
	@Test
	public void Productdefault_test() {
		Product p4=new Product();

		p4.setProductId(14);
		p4.setProductName("Pen");
		p4.setProductType("Sationary");
		p4.setCategory("Book");
		p4.setDescription("Point pen");
		p4.setPrice(5.0);
		p4.setRating("3.3");
		p4.setImage("img2.jpg");
		p4.setReview("Good");
		p4.setSpecification("for all");
	}

	
}

