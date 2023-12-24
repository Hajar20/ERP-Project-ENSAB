package com.erp.ensab.repository;

import com.erp.ensab.entities.Criteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriteriaRepository extends MongoRepository<Criteria,String> {
    Criteria findCriteriaByResponsableID(String id);

    Criteria findCriteriaByYear(int year);
}
