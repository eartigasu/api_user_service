package com.example.userservice.security;

import java.util.Date;
import java.util.UUID;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenUtil {

  public SecretKey generateKey() {
    return Keys.secretKeyFor(SignatureAlgorithm.HS512); // Genera una clave segura para HS512
  }

  public String generateToken(String email, SecretKey key) {
    return Jwts.builder().setSubject(email).setId(UUID.randomUUID().toString()).setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 día
        .signWith(key).compact();
  }
}
