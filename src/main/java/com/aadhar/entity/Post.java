package com.aadhar.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
	@Id
	private String postId;

	private String description;

	private String title;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "postFk", referencedColumnName = "postId")
	List<Comments> comments = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	//@JoinColumn(name = "UserFk", referencedColumnName = "userId")
	private User user;

}
