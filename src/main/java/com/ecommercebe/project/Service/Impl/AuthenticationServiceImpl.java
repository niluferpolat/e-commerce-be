package com.ecommercebe.project.Service.Impl;

import com.ecommercebe.project.Entity.Request.LoginRequest;
import com.ecommercebe.project.Entity.Request.SignupRequest;
import com.ecommercebe.project.Entity.Response.LoginResponse;
import com.ecommercebe.project.Entity.Role;
import com.ecommercebe.project.Entity.User;
import com.ecommercebe.project.Repository.RoleRepository;
import com.ecommercebe.project.Repository.UserRepository;
import com.ecommercebe.project.Service.AuthenticationService;
import com.ecommercebe.project.Service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public User signup(SignupRequest signupRequest) {
        User user = new User();
        user.setEmail(signupRequest.getEmail());
        user.setUsername(signupRequest.getUsername());
        Optional<Role> role = roleRepository.findById(Long.valueOf(2));
        user.setRole(role.get());
        user.setPassword(passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(user);
        return user;
    }

    public LoginResponse signin(LoginRequest loginRequest){
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword()));
        var user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
        var jwt = jwtService.generateToken(user);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwt);
        loginResponse.setRole(user.getRole().getName());
        loginResponse.setUsername(user.getUsername());
        return loginResponse;
    }
}
