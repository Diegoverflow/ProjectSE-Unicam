package it.unicam.cs.diciottoPolitico.casotto.utils.exception;

import io.jsonwebtoken.JwtException;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class GlobalExceptionHandlerFilter extends OncePerRequestFilter {

    private final HandlerExceptionResolver resolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);

        } catch (RuntimeException e) {

            this.resolver.resolveException(request, response, null, e);
        }
    }

}
