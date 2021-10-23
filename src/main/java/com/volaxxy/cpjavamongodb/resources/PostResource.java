package com.volaxxy.cpjavamongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.volaxxy.cpjavamongodb.domain.Post;
import com.volaxxy.cpjavamongodb.resources.util.URL;
import com.volaxxy.cpjavamongodb.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		
		return ResponseEntity.ok(post);
	}
	
	@RequestMapping(value = "/tittlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTittle(@RequestParam(value = "text", defaultValue = "") String text) {
		text = URL.decodeParam(text);
		List<Post> posts = postService.findByTittle(text);
		
		return ResponseEntity.ok(posts);
	}

}
