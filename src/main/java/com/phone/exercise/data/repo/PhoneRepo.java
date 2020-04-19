package com.phone.exercise.data.repo;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.phone.exercise.model.Phone;

/**
 * spring repository to deal with User table
 * @author Ankur Bansal
 *
 */
public interface PhoneRepo extends CrudRepository<Phone, UUID> {
	public Phone findByPhoneNumber(String phoneNumber);
}