package com.phone.exercise.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import com.phone.exercise.data.repo.PhoneRepo;
import com.phone.exercise.data.repo.UserRepo;
import com.phone.exercise.exception.PhoneNotFoundException;
import com.phone.exercise.exception.UserNotFoundException;
import com.phone.exercise.model.Phone;
import com.phone.exercise.model.User;

/**
 * 
 * @author Ankur Bansal
 * Class to handle addition or removal of a phone from a user
 *
 */
@RestController
public class UserRestController {

	@Autowired
	UserRepo userRepo;
	@Autowired
	PhoneRepo phoneRepo;
	private ObjectMapper objectMapper = new ObjectMapper();
	Logger logger = LoggerFactory.getLogger(UserRestController.class);

	/**
	 * Adds a phone to a given user and saves the phone in DB
	 * @param phone
	 * @param userId - for which a new phone need to be added
	 */
	@GetMapping("/users/addPhone/{userId}/{phoneId}")
	public void addPhoneToUser(@PathVariable String userId,@PathVariable String phoneId) {
		logger.debug("requested to add {} phone to {} user",phoneId, userId);
		User user = userRepo.findById(UUID.fromString(userId) ).orElseThrow(UserNotFoundException::new);
		Phone phone = phoneRepo.findById(UUID.fromString(phoneId)).orElseThrow(PhoneNotFoundException::new);
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
	@PostMapping("/users/removePhone/{userId}/{phoneId}")
	public void removePhoneFromUser(@PathVariable String userId,@PathVariable String phoneId) {
		logger.debug("requested to remove {} phone  from {} user",phoneId,userId);
		Phone phone = phoneRepo.findByPhoneNumber(phoneId);
		if(phone==null) {
			phone = phoneRepo.findById(UUID.fromString(phoneId)).orElseThrow(PhoneNotFoundException::new);
		}
		phone.setUser(null);			
		phoneRepo.save(phone);
	}


	@PatchMapping(path = "/users/changePreferredNumber/{userId}", consumes = "application/json-patch+json")
	public ResponseEntity<User> updateUser(@PathVariable String userId,
			@RequestBody JsonPatch patch) {
		logger.debug("requested to changePreferredNumber for {} user",userId);
		try {
			User user = userRepo.findById(UUID.fromString(userId)).orElseThrow(UserNotFoundException::new);
			User userPatched = applyPatchToUser(patch, user);
			userRepo.save(userPatched);

			return ResponseEntity.ok(userPatched);
		} catch (UserNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (JsonPatchException | JsonProcessingException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	private User applyPatchToUser(JsonPatch patch, User targetUser) throws JsonPatchException, JsonProcessingException {
		JsonNode patched = patch.apply(objectMapper.convertValue(targetUser, JsonNode.class));
		return objectMapper.treeToValue(patched, User.class);
	}

}
