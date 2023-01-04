package com.myprojects.springmongo.repositories;

import com.myprojects.springmongo.models.CompanyEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends MongoRepository<CompanyEntity, String> {

}
