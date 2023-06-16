package com.pers.persmongo.repository;

import com.pers.persmongo.model.Payroll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends MongoRepository<Payroll, Integer> {
}
