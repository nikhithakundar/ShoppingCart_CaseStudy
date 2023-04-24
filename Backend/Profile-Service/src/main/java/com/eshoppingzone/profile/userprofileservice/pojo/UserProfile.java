package com.eshoppingzone.profile.userprofileservice.pojo;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="userprofile")

public class UserProfile {
    @Id
    @Positive(message="Profile Id must be Positive")
    private  Integer profileId;
    
    @NotEmpty(message="Name should not be empty")
    private String fullName;
    
    
    @Email(message="Email must be valid")
    @NotEmpty(message="Email cannot be empty")
    @Indexed(unique=true)
    private String emailId;
    
    @NotNull
    private Long mobileNumber;
    
    
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
    
    private String gender;
   
    
    private Address address;
    
}































//private String password;

//@NotEmpty
//private String role;



