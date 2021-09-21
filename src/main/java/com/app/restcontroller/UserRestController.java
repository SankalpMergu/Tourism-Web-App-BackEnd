package com.app.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ErrorResponse;
import com.app.dto.LoginRequest;
import com.app.pojos.User;
//import com.app.pojos.User;
import com.app.service.IUserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserRestController {
	@Autowired
	private IUserService userService;
    public UserRestController() {
	System.out.println("in constructor of"+getClass().getName());
	}
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody @Valid LoginRequest transientUser){
		try {
			return new ResponseEntity<>(userService.userLogin(transientUser.getUserEmail(),transientUser.getUserPassword(),transientUser.getUserRole()),HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Login Failed.Invalid Credentials",e.getMessage()),HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> addNewUser(@RequestBody @Valid User trasientUser){
		try {
			return new ResponseEntity<>(userService.addUser(trasientUser), HttpStatus.OK);
		}catch(RuntimeException e) {
			return new ResponseEntity<>(new ErrorResponse("Adding User Failed",e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
