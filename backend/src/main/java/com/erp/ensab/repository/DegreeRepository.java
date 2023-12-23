package com.erp.ensab.repository;

import com.erp.ensab.entities.Degree;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DegreeRepository  extends MongoRepository<Degree,String> {
}
