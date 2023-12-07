package com.mrpalizatech.martinbank2.controller;

import com.mrpalizatech.martinbank2.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class RegisterRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String country;
    private Role role;
}
