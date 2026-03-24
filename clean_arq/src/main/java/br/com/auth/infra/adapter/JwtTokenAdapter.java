package br.com.auth.infra.adapter;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.auth.application.providers.JwtTokenProvider;
import br.com.auth.domain.Role;
import br.com.auth.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtTokenAdapter implements JwtTokenProvider {

    private final byte[] secretKey;
    private final long expiration;

    public JwtTokenAdapter(
        @Value("${security.jwt.secret}") String secret,
        @Value("${security.jwt.expiration}") long expiration
    ) {
        this.secretKey = secret.getBytes(StandardCharsets.UTF_8);
        this.expiration = expiration;
    }

    @Override
    public String generate(User user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole().name());

        Date now = new Date();
        Date expiry = new Date(now.getTime() + expiration);

        return Jwts.builder()
            .subject(user.getEmail())
            .claims(claims)
            .issuedAt(now)
            .expiration(expiry)
            .signWith(Keys.hmacShaKeyFor(secretKey))
            .compact();
    }

    @Override
    public boolean isValid(String token) {
        try {
            Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secretKey))
                .build()
                .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getEmail(String token) {
        return getClaims(token).getSubject();
    }

    @Override
    public Role getRole(String token) {
        return Role.valueOf(
            getClaims(token).get("role", String.class)
        );
    }

    private Claims getClaims(String token) {
        return Jwts.parser()
            .verifyWith(Keys.hmacShaKeyFor(secretKey))
            .build()
            .parseSignedClaims(token)
            .getPayload();
    }
}
