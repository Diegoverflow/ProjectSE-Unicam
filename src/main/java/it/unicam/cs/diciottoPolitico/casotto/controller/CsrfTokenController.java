package it.unicam.cs.diciottoPolitico.casotto.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@RestController
public class CsrfTokenController {

    @GetMapping("/csrf")
    public ResponseEntity<Cookie> getCrsfToken(HttpServletRequest request){
        var cookies = request.getCookies();

        for (Cookie c: cookies)
            if (c.getName().equals("XSRF-TOKEN"))
                return ResponseEntity.ok(c);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
