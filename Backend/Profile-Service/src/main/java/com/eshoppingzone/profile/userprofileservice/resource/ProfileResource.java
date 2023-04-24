package com.eshoppingzone.profile.userprofileservice.resource;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eshoppingzone.profile.exception.ProfileAlreadyExistsException;
import com.eshoppingzone.profile.exception.ProfileNotFoundException;

import com.eshoppingzone.profile.userprofileservice.pojo.LoggerResponse;
import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;


import com.eshoppingzone.profile.userprofileservice.service.ProfileServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/profile")
public class ProfileResource {
	@Autowired
	private ProfileServiceImpl profileServiceImpl;

	Logger logger = LoggerFactory.getLogger(LoggerResponse.class);

	
	@GetMapping("/users")
	public ResponseEntity<List<UserProfile>> getAllProfiles() {
		logger.info("All user details has been retrieved");
		return ResponseEntity.ok(profileServiceImpl.getAllProfiles());
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserProfile> getByProfileId(@PathVariable("id") int id) throws ProfileNotFoundException {
		logger.info("Details of the user is retrieved by the id");
		return ResponseEntity.ok(profileServiceImpl.getByProfileId(id));
	}

	@PostMapping("/add")
	public ResponseEntity<UserProfile> addNewCustomerProfile(@Valid @RequestBody UserProfile add)
			throws ProfileAlreadyExistsException {
		return ResponseEntity.ok(profileServiceImpl.addNewCustomerProfile(add));

	}

	@PutMapping("/update")
	public ResponseEntity<UserProfile> updateProfile(@Valid @RequestBody UserProfile u)
			throws ProfileNotFoundException {
		logger.info("Existing data has been updated");
		return ResponseEntity.ok(profileServiceImpl.updateProfile(u));
	}

	@DeleteMapping("/users/{profileId}")
	public void deleteProfile(@PathVariable("profileId") int profileId) throws ProfileNotFoundException {
		logger.info("An existing data has been deleted by using the id");
		profileServiceImpl.deleteProfile(profileId);
	}
	

}
