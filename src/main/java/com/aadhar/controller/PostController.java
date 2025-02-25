package com.aadhar.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadhar.dto.CommentsDto;
import com.aadhar.dto.PostDto;
import com.aadhar.entity.Comments;
import com.aadhar.entity.Post;
import com.aadhar.repo.PostRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	PostRepo postRepo;

	@PostMapping("/savePost")
	public ResponseEntity<Post> savePost(@RequestBody PostDto postDto) {
		System.out.println(postDto);
		List<Comments> commentsList = new ArrayList<>();
		for (CommentsDto commentDto : postDto.getComments()) {
			Comments comments = new Comments(commentDto.getCid(), commentDto.getComment());
			commentsList.add(comments);
		}
		Post post = new Post(postDto.getPostId(), postDto.getDescription(), postDto.getTitle(), commentsList, postDto.getUser());
		//postRepo.findById("130310028");
		log.info("post - {}", post);
		return new ResponseEntity<Post>(postRepo.save(post), HttpStatus.CREATED);
	}
	@GetMapping("/getAllPosts")
	public ResponseEntity<List<Post>> getAllPosts(){
		
		return ResponseEntity.ok(postRepo.findAll());
		
	}
		
	
	
	
	
	
	
	
	
	
	

}
