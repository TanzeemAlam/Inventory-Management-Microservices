package com.tanzeem.user_service.util;

import java.util.*;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

	private static final String SECRET_KEY = "TaK+HaV^uvCHEFsEVfypW#7g9^k*Z8$V";
	
	private SecretKey getSigningKey() {	
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}
	
	private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

	private String createToken(Map<String, Object> jwtClaims, String username) {
		return Jwts.builder()
				.claims(jwtClaims)
				.subject(username)
				.header().empty().add("typ", "JWT")
				.and()
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
				.signWith(getSigningKey())
				.compact();
		
	}
	
	public String generateToken(String username) {
		Map<String, Object> jwtClaims = new HashMap<>();
		return createToken(jwtClaims, username);
	}

	public String extractUsername(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
