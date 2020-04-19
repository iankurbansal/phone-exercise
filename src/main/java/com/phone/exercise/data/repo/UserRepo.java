package com.phone.exercise.data.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.phone.exercise.model.User;

/**
 * spring repository to deal with User table
 * @author Ankur Bansal
 *
 */
public interface UserRepo extends CrudRepository<User, UUID> {
	
	
}