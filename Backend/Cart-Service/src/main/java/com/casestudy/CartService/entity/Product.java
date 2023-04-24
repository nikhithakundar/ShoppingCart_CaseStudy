package com.casestudy.CartService.entity;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor 
@Document(collection = "products")
public class Product {
	
	 
	@Id
	private int productId;
	
	@NotEmpty(message="ProductType is empty")
	private String productType;
	@NotEmpty(message="Product Name is empty")
	private String productName;
	private String category;
	

	private double rating;
	
	private String review;
	private String image;
	
	@NotNull
	private double price;
	private String description;
	
	private String specification;
		
}