package com.aadhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aadhar.entity.Comments;
@Repository
public interface CommentRepo extends JpaRepository<Comments, String> {

}
