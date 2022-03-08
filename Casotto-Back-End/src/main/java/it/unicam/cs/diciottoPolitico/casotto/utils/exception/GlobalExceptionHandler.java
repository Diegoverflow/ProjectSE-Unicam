package it.unicam.cs.diciottoPolitico.casotto.utils.exception;

import io.jsonwebtoken.JwtException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    private ResponseEntity<?> handleConstraintViolation() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    private ResponseEntity<?> handleDataIntegrityViolation() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(JwtException.class)
    private ResponseEntity<Object> handleJwtException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{message : Token invalido}");
    }

    @ExceptionHandler(AuthenticationException.class)
    private ResponseEntity<Object> handleAuthenticationException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{message : Email e/o password non valide}");
    }
}
