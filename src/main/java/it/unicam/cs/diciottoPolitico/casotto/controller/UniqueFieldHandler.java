package it.unicam.cs.diciottoPolitico.casotto.controller;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface UniqueFieldHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    default ResponseEntity<Object> getUniqueFieldduplicateField() {
        return ResponseEntity.badRequest().build();
    }

}
