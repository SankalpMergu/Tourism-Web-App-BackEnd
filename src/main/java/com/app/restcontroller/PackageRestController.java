package com.app.restcontroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
 
import com.app.service.IPackageService;

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
}
