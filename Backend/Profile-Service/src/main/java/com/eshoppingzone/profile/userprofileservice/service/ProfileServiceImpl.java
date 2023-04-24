package com.eshoppingzone.profile.userprofileservice.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.eshoppingzone.profile.exception.ProfileAlreadyExistsException;
import com.eshoppingzone.profile.exception.ProfileNotFoundException;
import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.repository.ProfileRepository;

@Service
@Component
public class ProfileServiceImpl implements ProfileService {
	@Autowired
	ProfileRepository profileRepository;
	Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

	@Override
	public List<UserProfile> getAllProfiles() throws ProfileNotFoundException {
		logger.info("Get All Profile method is Started");
		
		List<UserProfile> profile = profileRepository.findAll();
		if (!profile.isEmpty()) {

			logger.info("If condition for Get all User profile is Started");
			logger.debug("User Profile details are :{}", profile);
			return profileRepository.findAll();
		} else {

			logger.info("If Else condition for Get all profile is Executed");
			throw new ProfileNotFoundException("No data's found");
		}

	}

	@Override
	public UserProfile getByProfileId(int profileId) throws ProfileNotFoundException {
		Optional<UserProfile> findByProfileId = profileRepository.findById(profileId);
		logger.info("Get By profile id started");
		if (findByProfileId.isPresent()) {
			logger.info("If condition for ProfileId profile Started");
			logger.debug("User details by id :{}", findByProfileId);
			return findByProfileId.get();
		} else {
			logger.info("IfElse condition for ProfileId executed");
			return findByProfileId.orElseThrow(() -> new ProfileNotFoundException(profileId + "User Does not Exists"));
		}

	}

	@Override
	public UserProfile addNewCustomerProfile(UserProfile userProfile) throws ProfileAlreadyExistsException {
		logger.info("Add new Customer method started");
		Optional<UserProfile> add = profileRepository.findById(userProfile.getProfileId());
		if (add.isEmpty()) {
			logger.info("If condition for add new Customer profile Started");
			logger.debug("Added user details are :{}", add);
			return profileRepository.insert(userProfile);
		} else {
			logger.info("If Else condition for add new Customer is executed");
			throw new ProfileAlreadyExistsException("Profile Already Exists");
		}

	}

	@Override
	public UserProfile updateProfile(UserProfile userProfile) throws ProfileNotFoundException {
		logger.info("Update User Profile method Started");
		Optional<UserProfile> updateByProfileId = profileRepository.findById(userProfile.getProfileId());
		if (updateByProfileId.isPresent()) {
			logger.info("If condition for Update User Profile is Started");
			return profileRepository.save(userProfile);
		} else {
			logger.info("If Else condition for Update User Profile is Executed");
			throw new ProfileNotFoundException("Its does not Exists for modification");
		}
	}

	@Override
	public void deleteProfile(int profileId) throws ProfileNotFoundException {
		logger.info("Delete User Profile method Started");
		Optional<UserProfile> findDeleteById = profileRepository.findById(profileId);
		if (findDeleteById.isPresent()) {
			logger.info("If condition for Delete User Profile Started");
			profileRepository.deleteById(profileId);
			logger.debug("User Profile deleted sucessfully {}", findDeleteById);

		} else {
			logger.info("If else condition of delete profile is executed");
			throw new ProfileNotFoundException("User Profile Does not Exists");
			
		}

	}

}
