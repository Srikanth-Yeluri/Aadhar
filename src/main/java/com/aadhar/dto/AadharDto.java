package com.aadhar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AadharDto {

	private String aadharNo;

	private String name;

	private String city;

	private double income;

}
