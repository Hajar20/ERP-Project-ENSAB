package com.erp.ensab.repository;

import com.erp.ensab.entities.Major;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorRepository extends MongoRepository<Major,String> {

    Major findByName(String name);
}
