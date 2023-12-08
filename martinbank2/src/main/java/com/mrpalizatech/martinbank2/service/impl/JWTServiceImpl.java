package com.mrpalizatech.martinbank2.service.impl;

import com.mrpalizatech.martinbank2.entity.UserEntity;
import com.mrpalizatech.martinbank2.service.JWTService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;
import java.util.function.Function;

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
        extraClaims.put("roles", userDetails.getAuthorities());
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
    @Override
    public String getUserNameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        final String userName = getUserNameFromToken(token);
        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSingInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);

        return claimsResolver.apply(claims);
    }
    private Date getExpirationDateFromToken(String token) {
        return getClaim(token, Claims::getExpiration);
    }
    private boolean isTokenExpired(String token) {

        return getExpirationDateFromToken(token).before(new Date());
    }
}
