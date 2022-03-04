package it.unicam.cs.diciottoPolitico.casotto.controller;

import it.unicam.cs.diciottoPolitico.casotto.model.SimpleUtente;
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
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UtenteService service;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login() {
        var utente = this.service.getBy((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        return ResponseEntity.ok(this.login(utente));
    }

    @GetMapping("/login")
    public ResponseEntity<Cookie> getCrsfToken(HttpServletRequest request){
        var cookies = request.getCookies();

        for (Cookie c: cookies)
            if (c.getName().equals("XSRF-TOKEN"))
                return ResponseEntity.ok(c);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
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
