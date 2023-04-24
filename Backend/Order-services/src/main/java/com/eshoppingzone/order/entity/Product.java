package com.eshoppingzone.order.entity;

import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nonapi.io.github.classgraph.json.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	@Id
	private Integer productId;
	private String productName;

}

