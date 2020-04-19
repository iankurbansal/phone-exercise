package com.phone.exercise.restService;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phone.exercise.model.User;
/**
 * 
 * @author Ankur Bansal
 * repository to handle rest requests related to User
 *
 */
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRestService extends PagingAndSortingRepository<User, UUID> {
}
