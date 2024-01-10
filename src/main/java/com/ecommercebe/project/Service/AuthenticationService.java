package com.ecommercebe.project.Service;

import com.ecommercebe.project.Entity.Request.LoginRequest;
import com.ecommercebe.project.Entity.Request.SignupRequest;
import com.ecommercebe.project.Entity.Response.LoginResponse;
import com.ecommercebe.project.Entity.User;

public interface AuthenticationService {
    User signup(SignupRequest signupRequest);
    LoginResponse signin(LoginRequest loginRequest);
}
