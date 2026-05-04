package com.software.microservicio_legajo_backend.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {

    // ⚠️ debe ser EXACTAMENTE la misma clave que usa el microservicio Usuarios
    private final String SECRET_KEY = "mi_clave_super_secreta_muy_larga_para_jwt_123456";

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // 📌 email viene en "sub"
    public String extractEmail(String token) {
        return getClaims(token).getSubject();
    }

    // 📌 rol viene en claim "rol"
    public String extractRol(String token) {
        return getClaims(token).get("rol", String.class);
    }

    public boolean isTokenExpired(String token) {
        Date expiration = getClaims(token).getExpiration();
        return expiration.before(new Date());
    }

    public boolean isTokenValid(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }
}