package com.app.TestUserService;

//import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.dto.LoginResponse;
import com.app.pojos.User;
import com.app.pojos.UserRole;
import com.app.service.IUserService;
@SpringBootTest
class TestUser {
	@Autowired
    private IUserService userService;
	@Test
	void testUserLogin() {
		 LoginResponse user=userService.userLogin("someone@gmail.com","1234566","CUSTOMER");
		 System.out.println(user);
	}
	
	@Test
	void testAddUser() {
		 User user=new User("something2@gmail.com","somebody2","something2","1234567899","12345",UserRole.CUSTOMER);
		 String userEmail=userService.addUser(user);
			 System.out.println(userEmail);
		
	}
}
