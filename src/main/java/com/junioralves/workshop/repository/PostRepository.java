package com.junioralves.workshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.junioralves.workshop.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
	
	@Query("{'title': {$regex :?0 , $options:'i'} }")
	List <Post> searcheTitle( String text);
	
	List <Post> findByTitleContainingIgnoreCase(String text); // Consulta
	
	
}
