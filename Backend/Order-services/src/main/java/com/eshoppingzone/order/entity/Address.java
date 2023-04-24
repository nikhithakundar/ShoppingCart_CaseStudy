package com.eshoppingzone.order.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orderaddress")
public class Address {
	
	@Id
	@Positive(message="customerId must be positive")
	private Integer customerId;
	
	@NotEmpty(message="Name should not be empty")
	private String fullName;
	
	@Size (min=10,max=10,message="mobile number must be 10")
	private String mobileNumber;
	
	private Integer flatNumber;
	private String city;
	
	
	private Integer pincode;
	private String state;

}
