package com.aadhar.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.aadhar.entity.Aadhar;
import com.aadhar.exception.NotFoundException;
import com.aadhar.exception.UserNotFoundException;
import com.aadhar.repo.AadharRepo;
import com.aadhar.service.AadharService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/aadhar")
//@EnableTransactionManagement
//@CacheConfig(cacheNames="allData")
public class AadharController {
	Logger log = LoggerFactory.getLogger(AadharController.class);
	@Autowired
	AadharRepo aadharRepo;
	@Autowired
	AadharService aadharService;
	@Autowired
	ApplicationContext ac;

//	{
//	    "postId": "130310029",
//	    "description": "postformoney",
//	    "title": "money",
//	    "comments": [
//	        {
//	            "comment": "demo",
//	            "cid": "1211"
//	        },
//	        {
//	            "comment": "demo2",
//	            "cid": "1231"
//	        }
//	    ],
//	    "user":{
//	        "userId":"5121"
//	    }
//	}

	@GetMapping("/allBeans")
	public String getBeans() {

		String[] beans = ac.getBeanDefinitionNames();
		for (int i = 0; i < beans.length; i++) {
			System.out.println(beans[i]);
			log.info(getBeans());
		}

		return "";
	}

	@PostMapping("/save")
	@CachePut(cacheNames = "allData", key = "'aadharNo'")
	public ResponseEntity<Aadhar> saveAadhar(@RequestBody Aadhar aadhar)
			throws IllegalArgumentException, IllegalAccessException {
		System.out.println("for testing.");
		return aadharService.saveEntity(aadhar);
	}

	@GetMapping("/getAll")
	// @Cacheable
	@Cacheable(cacheNames = "allData")
	public ResponseEntity<List<Aadhar>> getAllRecords() {
		return aadharService.getAllRecords();
//		log.info("casheing.");
//		System.out.println("connecting database.");
//		return ResponseEntity.ok(aadharRepo.findAll());

	}

	@GetMapping("/")
	public ResponseEntity<Aadhar> getAadhar(@RequestParam String id) throws UserNotFoundException {
		return ResponseEntity.ok(aadharRepo.findById(id)
				.orElseThrow(() -> new UserNotFoundException("user not found", "aaaaaaaaaa", "vvvvvvvvvvvv")));

	}

	@PutMapping("/delete/{id}")
	// @CacheEvict(key="#id")
	public ResponseEntity<String> deleteRecord(@PathVariable String id) throws UserNotFoundException {
		if (!aadharRepo.existsById(id)) {
			throw new UserNotFoundException(id, id, id);
		} else {
			aadharRepo.deleteById(id);
			return ResponseEntity.ok("Deletion success");
		}
	}

	@PutMapping("/update/{id}")
	// @CachePut(key="#aadharNo")
	public ResponseEntity<Aadhar> updateRecord(@PathVariable String id, @RequestBody Aadhar aadhar) {
		System.out.println("required param missing");
		Aadhar updateAadhar = aadharRepo.findById(id)
				.orElseThrow(() -> new NotFoundException("Resource Not Found" + id));
		updateAadhar.setCity(aadhar.getCity());
		aadharRepo.save(updateAadhar);
		return ResponseEntity.ok(updateAadhar);

	}

	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAllData() {
		try {
			aadharRepo.deleteAll();
		} catch (Exception ex) {
			return (ResponseEntity<String>) ResponseEntity.internalServerError();
		}
		return ResponseEntity.ok("All Records are Deleted..");

	}

	@PostMapping("/fileUpload")
	// @Transactional
	public void fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
		aadharService.saveFileData(file);
	}

	@PostMapping("/sample")
	public String testjson(@RequestBody Map<String, List<Map<String, Object>>> map) {

		for (Map.Entry<String, List<Map<String, Object>>> entry : map.entrySet()) {
			List<Map<String, Object>> list = entry.getValue();
			for (Map<String, Object> temp : list) {
				System.out.println(temp);

			}

		}

		return "test completed..";
	}

	@GetMapping("/getIp")
	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-FORWARDED-FOR");

		if (ip == null || ip.isEmpty()) {
			ip = request.getRemoteAddr();
		}

		return ip;
	}

	@GetMapping("/test")
	public String testApp(){
		return "Application is working";
	}

}
