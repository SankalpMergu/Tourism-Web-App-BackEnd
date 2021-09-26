package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.GuideRepository;
import com.app.pojos.Guide;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1")
public class GuideController {
	
	@Autowired
	private GuideRepository guideRepository;
	
	//get all guides list
	@GetMapping("/guides")
	public List<Guide> getGuides(){
		return guideRepository.findAll();
	}
	
	//create guide rest api
	@PostMapping("/guides")
	public Guide createGuide(@RequestBody Guide guide) {
		return guideRepository.save(guide);
	}
}
