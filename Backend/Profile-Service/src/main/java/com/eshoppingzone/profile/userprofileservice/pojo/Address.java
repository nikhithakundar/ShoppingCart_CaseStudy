package com.eshoppingzone.profile.userprofileservice.pojo;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection="address")
public class Address {
	
	@Id
	@Field(name="_id")
	
	private int houseNumber;
	private String streetName;
	private String colonyName;
	private String city;
	private String state;
	@NotNull
	private int pincode;
	

}
