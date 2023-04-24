package com.eshoppingzone.profile.userprofileservice.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.eshoppingzone.profile.exception.ProfileAlreadyExistsException;
import com.eshoppingzone.profile.exception.ProfileNotFoundException;
import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;

@Service
public interface ProfileService {

	public List<UserProfile> getAllProfiles();

	public UserProfile getByProfileId(int profileId) throws ProfileNotFoundException;

	public UserProfile addNewCustomerProfile(UserProfile userProfile) throws ProfileAlreadyExistsException;

	public UserProfile updateProfile(UserProfile userProfile) throws ProfileNotFoundException;

	public void deleteProfile(int profileId) throws ProfileNotFoundException;
	

}



