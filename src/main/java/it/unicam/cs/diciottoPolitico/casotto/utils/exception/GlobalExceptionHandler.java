package it.unicam.cs.diciottoPolitico.casotto.utils.exception;

import io.jsonwebtoken.JwtException;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoOmbrellone;
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
    private ResponseEntity<SimpleRigaCatalogoOmbrellone> handleDataIntegrityViolation() {
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(JwtException.class)
    private ResponseEntity<?> handleJwtException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ExceptionHandler(AuthenticationException.class)
    private ResponseEntity<?> handleAuthenticationException() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
