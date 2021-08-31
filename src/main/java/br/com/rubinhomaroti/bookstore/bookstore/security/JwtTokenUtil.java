package br.com.rubinhomaroti.bookstore.bookstore.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.*;
import java.util.*;

@Component
public class JwtTokenUtil {
    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expire}")
    private int expire;

    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>(); // Roles
        Date creationDate = getFromLocalDate(LocalDateTime.now());
        Date expirationDate =
                getFromLocalDate(LocalDateTime.now().plusMinutes(expire));
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(creationDate)
                .setExpiration(expirationDate)
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private Date getFromLocalDate(LocalDateTime now) {
        return Date.from(now.toInstant(OffsetDateTime.now().getOffset()));
    }

    public String getUsernameFromToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody();
        return claims.getSubject();
    }
}
