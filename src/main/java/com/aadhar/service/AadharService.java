package com.aadhar.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.elasticsearch.ElasticsearchProperties.Restclient;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.aadhar.dto.AadharDto;
import com.aadhar.entity.Aadhar;
import com.aadhar.exception.UserNotFoundException;
import com.aadhar.repo.AadharRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//@Transactional
//@Profile(value = { "prod", "QA" })
public class AadharService {

	@Autowired
	AadharRepo aadharRepo;

//	@Transactional

	public void saveFileData(MultipartFile file) throws IOException {
		String[] temp = null;
		byte[] bytes = file.getBytes();
		String[] data = new String(bytes).split("\n");
		for (int i = 1; i < data.length; i++) {
			temp = data[i].split(",");
			log.info(temp.toString());
			Aadhar aadhar = new Aadhar(temp[0], temp[1], temp[2], Double.parseDouble(temp[3]));
			aadharRepo.save(aadhar);
		}

	}

	
	public ResponseEntity<List<Aadhar>> getAllRecords() {
		log.info("casheing.");
		System.out.println("connecting database.");
		return ResponseEntity.ok(aadharRepo.findAll());

	}
//	@CachePut(cacheNames ="allData",key= "#aadhar.aadharNo")
//	public ResponseEntity<String> deleteRecord(@PathVariable String id) throws UserNotFoundException {
//		if (!aadharRepo.existsById(id)) {
//			throw new UserNotFoundException(id, id, id);
//		} else {
//			aadharRepo.deleteById(id);
//			return ResponseEntity.ok("Deletion success");
//		}
//	}

	
	public ResponseEntity<Aadhar> saveEntity(Aadhar aadhar) {

		System.out.println("save object.");

		return new ResponseEntity<Aadhar>(aadharRepo.save(aadhar), HttpStatus.CREATED);

	}

}
