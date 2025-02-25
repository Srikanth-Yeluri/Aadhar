package com.aadhar.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aadhar.entity.Aadhar;

public interface AadharRepo extends JpaRepository<Aadhar,String>{

}
