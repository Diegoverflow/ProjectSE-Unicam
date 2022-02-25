package it.unicam.cs.diciottoPolitico.casotto.security.jwt;

import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class JwtUtil {

    public static String createToken(String subject, JwtConfig jwtConfig, Collection<? extends GrantedAuthority> authorities) {
        return Jwts.builder()
                .setSubject(subject)
                .claim("authorities", authorities)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpirationAfterDays())))
                .signWith(jwtConfig.getSecretKey())
                .compact();
    }

    public static UsernamePasswordAuthenticationToken parseToken(String token, JwtConfig jwtConfig) {
        var jws = Jwts.parserBuilder()
                .setSigningKey(jwtConfig.getSecretKey())
                .build()
                .parseClaimsJws(token);

        var body = jws.getBody();

        var email = body.getSubject();

        @SuppressWarnings("unchecked")
        var authorities = (List<Map<String, String>>) body.get("authorities");

        var simpleGrantedAuthorities = authorities.stream()
                .map(m -> new SimpleGrantedAuthority(m.get("authority")))
                .collect(Collectors.toSet());

        return new UsernamePasswordAuthenticationToken(
                email,
                null,
                simpleGrantedAuthorities
        );
    }

}
