package site.liberumscientia.postshandler.jwt;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.JwtException;
import java.security.Key;

@Component
public class JwtTokenUtil {

    private final String secretKey = "sua-chave-secreta-bem-forte-e-longa"; // Idealmente, use uma chave segura e longa
    private final Key key = Keys.hmacShaKeyFor(secretKey.getBytes()); // Converte para uma chave HMAC adequada

    // Extrai o username do token JWT
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Valida o token JWT
    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            System.out.println("Token inválido ou malformado.");
        }
        return false;
    }
}

