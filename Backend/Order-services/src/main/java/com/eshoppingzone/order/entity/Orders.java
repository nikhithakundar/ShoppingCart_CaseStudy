package com.eshoppingzone.order.entity;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "order")
public class Orders {
	
	@Id
	@Positive(message="OrderId must be positive")
	private Integer orderId;
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
	private LocalDate orderDate;
	
	@Positive(message="Customer Id must be Positive")
	private Integer customerId;
	
	@NotNull
	private Double amountPaid;
	
	@NotEmpty
	private String modeOfPayment;
	
	private String orderStatus;
	
	private Integer quantity;
	
	private Address address;
	private Cart cart;
	private int productId;


}
