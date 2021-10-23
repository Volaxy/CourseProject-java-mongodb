package com.volaxxy.cpjavamongodb.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.volaxxy.cpjavamongodb.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

	List<Post> findByTittleContainingIgnoreCase(String text);
	
}
