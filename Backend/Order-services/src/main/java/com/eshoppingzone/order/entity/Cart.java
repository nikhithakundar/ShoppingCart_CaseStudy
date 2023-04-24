package com.eshoppingzone.order.entity;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cart")
public class Cart {
	
	@Id
	private int cartid;
	private double totalPrice;
	private Product product;
	
	

}
