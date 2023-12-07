package com.mrpalizatech.martinbank2.service.impl;

import com.mrpalizatech.martinbank2.entity.UserEntity;
import com.mrpalizatech.martinbank2.service.JWTService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Objects;

@Service
public class JWTServiceImpl implements JWTService {

    private static final String SECRET_KEY = "e0e52ccc4cfdac144df59c15224b6b2e1ab4709d290e0873a7ab1138c2076b82";
    @Override
    public String generateToken(UserDetails userDetails) {
        System.out.println("In generateToken userDetails: " + userDetails);
        return getToken(userDetails);
    }

    @Override
    public String getToken(UserDetails userDetails) {
        HashMap<String, Object> extraClaims = new HashMap<>();
        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new java.util.Date(System.currentTimeMillis()))
                .setExpiration(new java.util.Date(System.currentTimeMillis() + 1000*60*60*24))
                .signWith(getSingInKey(), io.jsonwebtoken.SignatureAlgorithm.HS256)
                .compact();

    }

    private Key getSingInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
