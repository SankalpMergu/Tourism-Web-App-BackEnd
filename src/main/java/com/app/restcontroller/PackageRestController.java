package com.app.restcontroller;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.UserRepository;
import com.app.dto.BookingRequest;
import com.app.dto.ErrorResponse;
import com.app.pojos.Booking;
import com.app.pojos.BookingStatus;
import com.app.pojos.TourPackages;
import com.app.pojos.User;
import com.app.service.IPackageService;
import com.app.service.IUserService;

@RestController
@RequestMapping("/api/tour")
@CrossOrigin
public class PackageRestController {
	@Autowired
	private IPackageService packService;
	
	
	@GetMapping("/packages")
	public ResponseEntity<?> fetchAllPackages(){
		try {
			return new ResponseEntity<>(packService.getAllPackages(),HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Failed Fetching Tour Packages!!! ",e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPackageById(@PathVariable int packageId){
		try {
			return new ResponseEntity<>(null, null);
		}catch(RuntimeException e){
			return new ResponseEntity<>("Failed to get The Package Details", HttpStatus.BAD_REQUEST);	
		}
	}
	
	
	
	}
