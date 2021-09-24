package com.app.service;

import com.app.dto.LoginResponse;
import com.app.pojos.User;

public interface IUserService {
LoginResponse userLogin(String email,String password,String role);
String addUser(User newUser);
User getDetails(String userEmail);
User updateDetails(User detachedUser);
}
