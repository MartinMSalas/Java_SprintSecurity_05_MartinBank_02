package com.mrpalizatech.martinbank2.service;

import com.mrpalizatech.martinbank2.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(UserDetails userDetails);

    String getToken(UserDetails userDetails);
}
