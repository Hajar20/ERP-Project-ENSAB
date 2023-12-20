package com.erp.ensab.repository;

import com.erp.ensab.entities.Responsable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsableRepository  extends MongoRepository<Responsable,String> {
    Optional<Responsable> findByEmail(String email);
    Boolean existsByEmail(String email);
}
