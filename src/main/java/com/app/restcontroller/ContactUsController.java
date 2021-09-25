package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ContactUsRepository;
import com.app.pojos.ContactUs;

@CrossOrigin
@RestController
@RequestMapping("/api/project")
public class ContactUsController {
	
	@Autowired
	private ContactUsRepository repository;
	
	//get all contact us details
//	@GetMapping("/contactus")
//	public List<ContactUs> getAllContactUs()
//	{
//		return repository.findAll();
//	}
	
	@PostMapping("/addcontactus")
	public ContactUs addContactUS(@RequestBody ContactUs cont)
	{
		return repository.save(cont);
	}
}
