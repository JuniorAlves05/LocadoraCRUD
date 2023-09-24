package com.junior.locadora.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.junior.locadora.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
	
}


