package com.app.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.app.dao.UserRepository;
import com.app.dto.ErrorResponse;
import com.app.dto.LoginResponse;
import com.app.pojos.User;

import custom_exception.UserHandlingException;
@Service 
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
    private UserRepository userRepo;
	public UserServiceImpl() {
	 System.out.println("in constructor of"+getClass().getName());
	}
	@Override
	public LoginResponse userLogin(String userEmail, String userPassword,String roleType) {
		User user =userRepo.findByEmailAndPassword(userEmail,userPassword).
				 orElseThrow(()->new UserHandlingException("Auth Failed.Invalid Email and Password!!!"));
	     
		if(roleType.equals(user.getRole().toString())) {
			//return new LoginResponse(user.getEmail());
			return new LoginResponse(user.getEmail(),user.getRole());
		}else {
            throw new UserHandlingException("No email with this Role");			
		}
 
	}
	
	@Override
	public String addUser(User newUser) {
		System.out.println(newUser.getEmail());
		boolean user=userRepo.existsByEmail(newUser.getEmail());
		if(user) {
		    throw new UserHandlingException("Account Already Exist");
		}else {
			userRepo.save(newUser);
			newUser.setRegisterDate(LocalDateTime.now());
			return "User Added Successfully";
			
		}
		
	}
	
	
	@Override
	public User getDetails(String userEmail) {
		return userRepo.findByEmail(userEmail).
				orElseThrow(() -> new UserHandlingException("Invalid User ID !!!!!"));
		
	}

	@Override
	public User updateDetails(User detachedUser) {
		return userRepo.save(detachedUser);
	}
	

}
 