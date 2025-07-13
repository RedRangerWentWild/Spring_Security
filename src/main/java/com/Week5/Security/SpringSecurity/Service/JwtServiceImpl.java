package com.Week5.Security.SpringSecurity.Service;

import com.Week5.Security.SpringSecurity.Entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Set;

@Service
public class JwtServiceImpl {
    @Value("${jwt.secretKey}")
    private String JwtSecretKey;
    public SecretKey getSecretKey(){
        return Keys.hmacShaKeyFor(JwtSecretKey.getBytes(StandardCharsets.UTF_8));
    }
    public String generateToken(User user){
       return Jwts.builder()
                .subject(user.getId().toString())
                .claim("email",user.getEmail())
                .claim("roles", Set.of("Admin","User"))
                .issuedAt(new Date(System.currentTimeMillis() +1000*60))
                .signWith(getSecretKey())
                .compact();
    }
    public Long getUserIdFromToken(String token){
        Claims claims=Jwts.parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return Long.valueOf(claims.getSubject());
    }
}
