package com.aadhar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
public class AadharApplication {

	Logger log = LoggerFactory.getLogger(AadharApplication.class);

	public static void main(String[] args){
		SpringApplication.run(AadharApplication.class, args);
	}

	
	
	
}
