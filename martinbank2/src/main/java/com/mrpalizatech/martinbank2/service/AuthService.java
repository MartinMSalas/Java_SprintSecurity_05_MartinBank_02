package com.mrpalizatech.martinbank2.service;

import com.mrpalizatech.martinbank2.controller.AuthResponse;
import com.mrpalizatech.martinbank2.controller.LoginRequest;
import com.mrpalizatech.martinbank2.controller.RegisterRequest;

public interface AuthService {

    AuthResponse login(LoginRequest request);

    AuthResponse register(RegisterRequest request);
}
