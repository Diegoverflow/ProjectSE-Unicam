package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleRigaCatalogoOmbrellone;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface UniqueFieldHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    default ResponseEntity<SimpleRigaCatalogoOmbrellone> duplicateOmbrellone() {
        return ResponseEntity.badRequest().build();
    }

}
