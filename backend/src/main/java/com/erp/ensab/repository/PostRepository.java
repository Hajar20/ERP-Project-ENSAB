package com.erp.ensab.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.erp.ensab.entities.*;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {

}
