package com.eshoppingzone.order.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Items {

	@NotEmpty
	private String productName;
	@NotEmpty
	@Min(0)
	private Double price;
	@Min(1)
	private Integer quantity;
	
}

