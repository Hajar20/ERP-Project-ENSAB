package com.erp.ensab.repository;


import com.erp.ensab.entities.Candidate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CandidateRepository  extends MongoRepository<Candidate,String> {
    boolean existsByCne(String cne);
}
