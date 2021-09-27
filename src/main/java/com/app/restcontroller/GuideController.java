package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.GuideRepository;
import com.app.pojos.Guide;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GuideController {
	
	@Autowired
	private GuideRepository guideRepository;
	
	//get all guides list
	@GetMapping("/guides")
	public List<Guide> getGuides(){
		return guideRepository.findAll();
	}
	
	//create guide rest api
	@PostMapping("/guide")
	public Guide createGuide(@RequestBody Guide guide) {
		System.out.println(guide);
		return guideRepository.save(guide);
	}
	
	@DeleteMapping("/{guideId}")
	public ResponseEntity<?> deleteUserDetails(@PathVariable int guideId) {
		System.out.println("in delete user details " + guideId);
		guideRepository.deleteById(guideId);
		return ResponseEntity.ok("successfully deleted the guide");
	}
	
}
