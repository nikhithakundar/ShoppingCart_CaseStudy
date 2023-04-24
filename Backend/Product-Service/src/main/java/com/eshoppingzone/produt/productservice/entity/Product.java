package com.eshoppingzone.produt.productservice.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@Document(collection = "products")
public class Product {
	
	
	@Id
	@Positive(message="Product Id must be Postive Value")
	private int productId;

	@NotEmpty(message = "Product Type cannot be empty")
	private String productType;

	@NotEmpty(message = "product name cannot be empty")
	private String productName;

	@NotEmpty(message = "product category cannot be empty")
	private String category;

	private String rating;

	private String review;
	private String image;

	@NotNull
	private double price;

	private String description;

	private String specification;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, @NotEmpty(message = "Product cannot be empty") String productType,
			@NotEmpty(message = "product name cannot be empty") String productName, String category, String rating,
			String review, String image, @NotNull double price, String description, String specification) {
		super();
		this.productId = productId;
		this.productType = productType;
		this.productName = productName;
		this.category = category;
		this.rating = rating;
		this.review = review;
		this.image = image;
		this.price = price;
		this.description = description;
		this.specification = specification;
	}

	


}
