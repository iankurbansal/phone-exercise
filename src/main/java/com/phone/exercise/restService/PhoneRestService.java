package com.phone.exercise.restService;

import java.util.UUID;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.phone.exercise.model.Phone;
/**
 * 
 * @author Ankur Bansal
 * repository to handle rest requests related to Phone
 *
 */
@RepositoryRestResource(collectionResourceRel = "phones", path = "phones")
public interface PhoneRestService extends PagingAndSortingRepository<Phone, UUID> {

}
