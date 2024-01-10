package com.ecommercebe.project.Controller;

import com.ecommercebe.project.Entity.Request.LoginRequest;
import com.ecommercebe.project.Entity.Request.SignupRequest;
import com.ecommercebe.project.Entity.Response.LoginResponse;
import com.ecommercebe.project.Entity.User;
import com.ecommercebe.project.Service.AuthenticationService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/auth")
@RequiredArgsConstructor
public class UserController {
  private final AuthenticationService authenticationService;

  @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody SignupRequest signupRequest){
      return ResponseEntity.ok(authenticationService.signup(signupRequest));
  }

  @PostMapping("/signin")
  public ResponseEntity<LoginResponse> signin(@RequestBody LoginRequest loginRequest){
      return ResponseEntity.ok(authenticationService.signin(loginRequest));
  }
}
