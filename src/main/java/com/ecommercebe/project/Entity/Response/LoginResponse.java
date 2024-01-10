package com.ecommercebe.project.Entity.Response;

import com.ecommercebe.project.Entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {
    private String token;
    private String username;
    private String role;

}
