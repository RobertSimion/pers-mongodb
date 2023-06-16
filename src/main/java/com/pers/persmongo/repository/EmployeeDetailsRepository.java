package com.pers.persmongo.repository;

import com.pers.persmongo.model.EmployeeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeDetailsRepository extends MongoRepository<EmployeeDetails, Integer> {

}
