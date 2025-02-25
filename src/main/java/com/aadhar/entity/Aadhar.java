package com.aadhar.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Aadhar {

	@Id
	@Column(name = "aadhar_no")
	private String aadharNo;

	private String name;

	private String city;

	private double income;

}
