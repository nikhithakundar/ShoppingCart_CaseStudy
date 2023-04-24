package com.eshopping.profile.userprofileservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import com.eshoppingzone.profile.userprofileservice.pojo.Address;
import com.eshoppingzone.profile.userprofileservice.pojo.UserProfile;
import com.eshoppingzone.profile.userprofileservice.repository.ProfileRepository;
import com.eshoppingzone.profile.userprofileservice.resource.ProfileResource;
import com.eshoppingzone.profile.userprofileservice.service.ProfileServiceImpl;

@SpringBootTest(classes = { UserProfile.class })
class ProfileTestCase {
	@MockBean
	ProfileRepository profileRepository;

	@Mock
	ProfileServiceImpl profileServiceImpl;

	@InjectMocks
	ProfileResource profileResource;

	List<UserProfile> userprofiles;
	UserProfile userprofile;

	@Test
	public void test_getAllProfiles() {
		userprofiles = new ArrayList<>();
		userprofiles.add(new UserProfile(1, "Nikki", "mail@com", 123637424L,LocalDate.of(2001, 12, 01), "female", null));
		userprofiles.add(new UserProfile(2, "Venu","mail@com", 782387525L,LocalDate.of(01, 9, 05), "male", null));

		when(profileServiceImpl.getAllProfiles()).thenReturn(userprofiles);
		ResponseEntity<List<UserProfile>> allprofiles = profileResource.getAllProfiles();
		assertEquals(2, allprofiles.getBody().size());
	}

	@Test
	public void test_getByProfileId() {

		userprofile = new UserProfile(1, "Nikki",  "mail@com", 123637424L,  LocalDate.of(2001, 12, 01),"female", null);
		int profileId = 1;

		when(profileServiceImpl.getByProfileId(profileId)).thenReturn(userprofile);
		ResponseEntity<UserProfile> profileid = profileResource.getByProfileId(profileId);
		assertEquals(profileId, profileid.getBody().getProfileId());
	}

	@Test
	public void test_addNewCustomerProfile() {

		userprofile = new UserProfile(2, "Venu", "mail@com", 782387525L,  LocalDate.of(01, 9, 05),"male", null);

		int profileId = 2;

		when(profileServiceImpl.getByProfileId(profileId)).thenReturn(userprofile);
		when(profileServiceImpl.addNewCustomerProfile(userprofile)).thenReturn(userprofile);
		ResponseEntity<UserProfile> addUser = profileResource.addNewCustomerProfile(userprofile);
		assertEquals(profileId, addUser.getBody().getProfileId());
	}

	@Test
	public void test_updateProfile() {
		userprofile = new UserProfile(2, "Venu",  "mail@com", 782387525L,  LocalDate.of(01, 9, 05),"male", null);
		int profileId = 2;

		when(profileServiceImpl.getByProfileId(profileId)).thenReturn(userprofile);
		when(profileServiceImpl.updateProfile(userprofile)).thenReturn(userprofile);
		ResponseEntity<UserProfile> update = profileResource.getByProfileId(profileId);
		assertEquals(2, update.getBody().getProfileId());
	}

	@Test
	public void test_deleteProfile() {

		userprofile = new UserProfile(2, "Venu",  "mail@com", 782387525L,  LocalDate.of(01, 9, 05),"male", null);
		int profileId = 1;
		profileRepository.deleteById(profileId);

	}

	@Test
	public void getAllProfiletest() {
		List<UserProfile> users = new ArrayList<>();
		UserProfile u = new UserProfile();

		u.setProfileId(11);
		u.setFullName("Nikki");
		u.setGender("female");
		u.setDateOfBirth(LocalDate.of(2002, 5, 12));
		u.setEmailId("nikki@gmail.com");
		

		users.add(u);

		when(profileRepository.findAll()).thenReturn(users);
		// assertEquals(1, profileServiceImpl.getAllProfiles().size());
	}

	@Test
	public void getByProfileId_test() {
		UserProfile u = new UserProfile();

		u.setProfileId(11);
		u.setFullName("Nikki");
		u.setGender("female");
		u.setDateOfBirth(LocalDate.of(2002, 5, 12));
		u.setEmailId("nikki@gmail.com");
	
		

		Optional<UserProfile> userprofile = Optional.of(u);
		when(profileRepository.findById(11)).thenReturn(userprofile);
		//assertEquals(u, profileServiceImpl.getByProfileId(11));
	}

	@Test
	public void addProfile_test() {

		UserProfile u1 = new UserProfile();

		u1.setProfileId(11);
		u1.setFullName("Nikki");
		u1.setGender("female");
		u1.setDateOfBirth(LocalDate.of(2002, 5, 12));
		u1.setEmailId("nikki@gmail.com");
		
		

		when(profileRepository.insert(u1)).thenReturn(u1);
		//assertEquals(u1, profileServiceImpl.addNewCustomerProfile(u1));

	}
	

	@Test
	public void UpdateProfile_test() {

		UserProfile u1 = new UserProfile();
		UserProfile u2 = new UserProfile();
		
		
		u1.setProfileId(11);
		u1.setFullName("Nikki");
		u1.setGender("female");
		u1.setDateOfBirth(LocalDate.of(2002, 5, 12));
		u1.setEmailId("nikki@gmail.com");
	
		
		u2.setProfileId(11);
		u2.setFullName("Nikki");
		u2.setGender("female");
		u2.setDateOfBirth(LocalDate.of(2002, 5, 12));
		u2.setEmailId("nikki@gmail.com");
	

		Optional<UserProfile> product = Optional.of(u1);

		when(profileRepository.findById(14)).thenReturn(product);
		when(profileRepository.save(u2)).thenReturn(u2);
		//assertEquals(u2, profileServiceImpl.updateProfile(u2));
	}
	

	@Test
	public void deleteProfile_test() {

		UserProfile u1 = new UserProfile();

		u1.setProfileId(11);
		u1.setFullName("Nikki");
		u1.setGender("female");
		u1.setDateOfBirth(LocalDate.of(2002, 5, 12));
		u1.setEmailId("nikki@gmail.com");
		
		

		Optional<UserProfile> delete = Optional.of(u1);
		when(profileRepository.findById(11)).thenReturn(delete);
		//assertEquals("Deleted successfully", profileServiceImpl.deleteProfile(11));
		
	}

	@Test
	public void profileConstructors_test() {
		
		Address ad=new Address(1, "Mahatma", "gandhi", "bang","KA", 783467);
		UserProfile u=new UserProfile(2, "Venu", "mail@com", 782387525L, LocalDate.of(01, 9, 05),"male", ad);
		u.setDateOfBirth(LocalDate.of(01, 9, 05));
		u.setEmailId("mail@com");
		u.setFullName("Venu");
		u.setGender("male");
		u.setMobileNumber(782387525L);
		u.setProfileId(2);
		u.setAddress(ad);
	}
	
	@Test
	public void profileConstructor_test() {
		UserProfile u=new UserProfile();
		Address ad=new Address();
		u.setDateOfBirth(LocalDate.of(01, 9, 05));
		u.setEmailId("mail@com");
		u.setFullName("Venu");
		u.setGender("male");
		u.setMobileNumber(782387525L);
		u.setProfileId(2);
		u.setAddress(ad);
	}
	


		

}
