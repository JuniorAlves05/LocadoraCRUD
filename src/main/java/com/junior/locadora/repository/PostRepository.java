package com.junior.locadora.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.junior.locadora.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String>{
	
}


