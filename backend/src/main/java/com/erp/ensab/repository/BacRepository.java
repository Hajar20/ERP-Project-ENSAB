package com.erp.ensab.repository;

import com.erp.ensab.entities.Bac;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BacRepository  extends MongoRepository<Bac,String> {
}
