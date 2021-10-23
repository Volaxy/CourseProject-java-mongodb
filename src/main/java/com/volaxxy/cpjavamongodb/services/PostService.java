package com.volaxxy.cpjavamongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.volaxxy.cpjavamongodb.domain.Post;
import com.volaxxy.cpjavamongodb.repositories.PostRepository;
import com.volaxxy.cpjavamongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Object not found! :("));
	}
	
	public List<Post> findByTittle(String text) {
		return postRepository.findByTittleContainingIgnoreCase(text);
	}

}
