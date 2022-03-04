package it.unicam.cs.diciottoPolitico.casotto.controller;

import com.google.zxing.common.StringUtils;
import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;
import it.unicam.cs.diciottoPolitico.casotto.security.UtenteWrapper;
import it.unicam.cs.diciottoPolitico.casotto.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UtenteService service;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login() {
        var utenteWrapper = (UtenteWrapper)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var utente = this.service.getBy(utenteWrapper.getUsername()); // il getUsername ritorna l'email

        return ResponseEntity.ok(this.login(utente));
    }

    @GetMapping("/login")
    public ResponseEntity<?> getCrsfToken(){
        return ResponseEntity.ok(null);
    }

    private Map<String, Object> login(SimpleUtente utente){
        var map = new LinkedHashMap<String,Object>();
        map.put("id",utente.getId());
        map.put("email",utente.getEmail());
        map.put("cognome",utente.getCognome());
        map.put("cellulare",utente.getCellulare());
        map.put("ruolo",utente.getRuoloUtente());
        return map;
    }
}
