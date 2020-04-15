package com.phone.exercise.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phone.exercise.data.repo.PhoneRepo;
import com.phone.exercise.data.repo.UserRepo;
import com.phone.exercise.entity.Phone;
import com.phone.exercise.entity.User;

/**
 * 
 * @author Ankur Bansal
 * Class to handle addition or removal of a phone from a user
 *
 */
@RestController
public class UserRestService {

	@Autowired
	UserRepo userRepo;
	@Autowired
	PhoneRepo phoneRepo;

	/**
	 * Adds a phone to a given user and saves the phone in DB
	 * @param phone
	 * @param userId - for which a new phone need to be added
	 */
	@PatchMapping("/users/addPhone/{userId}")
	public void addPhoneToUser(@RequestBody Phone phone, @PathVariable String userId) {
		User user = userRepo.findById(UUID.fromString(userId) ).get();
		phone.setUser(user);
		phoneRepo.save(phone);
		if(user!=null && phone!=null){
			user.addPhone(phone);
		}
	}

	/**
	 * Removes a phone from a User. The phone is not deleted from the DB but user is set to null
	 * @param userId
	 * @param phoneId
	 */
	@PatchMapping("/users/removePhone/{userId}/{phoneId}")
	public void removePhoneFromUser(@PathVariable String userId,@PathVariable String phoneId) {
		User user = userRepo.findById(UUID.fromString(userId)).get();
		Phone phone = phoneRepo.findByPhoneNumber(phoneId);
		if(phone==null) {
			phone = phoneRepo.findById(UUID.fromString(phoneId)).orElse(null);
		}
		if(user!=null && phone!=null){
			phone.setUser(null);			
			phoneRepo.save(phone);
		}
	}

}
