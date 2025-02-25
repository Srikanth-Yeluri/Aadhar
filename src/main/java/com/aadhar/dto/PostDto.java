package com.aadhar.dto;

import java.util.List;

import com.aadhar.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PostDto {
	private String postId;
	private String description;
	private String title;
	private List<CommentsDto> comments;
	private User user;
}
