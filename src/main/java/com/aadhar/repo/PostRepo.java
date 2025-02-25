package com.aadhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aadhar.entity.Post;
@Repository
public interface PostRepo extends JpaRepository<Post, String> {
	
	
	

}
