package it.unicam.cs.diciottoPolitico.casotto.security.jwt;

import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

@ConfigurationProperties("application.jwt")
@Component
@Getter
@Setter
public class JwtConfig {

    private String cookieName;
    private String secretKeyValue;
    private int tokenExpirationAfterDays;

    public SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(this.secretKeyValue.getBytes());
    }
}
