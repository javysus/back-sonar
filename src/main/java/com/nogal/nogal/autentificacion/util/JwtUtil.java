package com.nogal.nogal.autentificacion.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import com.nogal.nogal.autentificacion.modelos.User;
import com.nogal.nogal.autentificacion.servicios.UserServicio;

@Service
public class JwtUtil {

    private String secretKey = "secret"; // key que se usa para crear el token

    @Autowired
    UserServicio userService;

    // toma un usuario y crea un token a partir del user
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>(); // detalles que podemos agregar
        return createToken(claims, userDetails.getUsername());
    }


    private String createToken(Map<String, Object> claims, String subject) { // subject, quien se esta logeando
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // expira en 10 horas
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }

    // extraigo cosas del token (user o expiracion)
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    // a partir del token extraigo info que necesito
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    // a partir del user y el token ve si son iguales
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // a partir de un token obtener el id del usuario
    public long extractId(String token){
        String user = this.extractUsername(token);

        User usuario = userService.obtenerNombre(user);

        if(usuario != null){
            return usuario.getId();
        } else{
            return 0;
        }
    }
}