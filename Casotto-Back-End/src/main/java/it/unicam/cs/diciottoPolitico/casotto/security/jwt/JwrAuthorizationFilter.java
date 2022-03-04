package it.unicam.cs.diciottoPolitico.casotto.security.jwt;

import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@AllArgsConstructor
public class JwrAuthorizationFilter extends OncePerRequestFilter {

    private final JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var cookie = Arrays.stream(request.getCookies())
                .filter(c -> c.getName().equals("access-token"))
                .findFirst();

        if (cookie.isEmpty()) {
            filterChain.doFilter(request, response);
            return;
        }

        var token = cookie.get().getValue();

        var authentication = JwtUtil.parseToken(token, this.jwtConfig);

        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        return request.getRequestURI().equals("/login")
                &&
                (request.getMethod().equals("GET") || request.getMethod().equals("POST"));
    }

}
