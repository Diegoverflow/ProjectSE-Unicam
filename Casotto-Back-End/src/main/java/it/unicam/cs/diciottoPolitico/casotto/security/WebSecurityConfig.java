package it.unicam.cs.diciottoPolitico.casotto.security;

import it.unicam.cs.diciottoPolitico.casotto.security.jwt.JwrAuthorizationFilter;
import it.unicam.cs.diciottoPolitico.casotto.security.jwt.JwtAuthenticationFilter;
import it.unicam.cs.diciottoPolitico.casotto.security.jwt.JwtConfig;
import it.unicam.cs.diciottoPolitico.casotto.utils.exception.GlobalExceptionHandlerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    private final PasswordEncoder passwordEncoder;
    private final UserDetailsService userDetailsService;
    private final JwtConfig jwtConfig;
    private final HandlerExceptionResolver handlerExceptionResolver;

    @Autowired
    protected WebSecurityConfig(PasswordEncoder passwordEncoder, UserDetailsService userDetailsService, JwtConfig jwtConfig, HandlerExceptionResolver handlerExceptionResolver) {
        this.passwordEncoder = passwordEncoder;
        this.userDetailsService = userDetailsService;
        this.jwtConfig = jwtConfig;
        this.handlerExceptionResolver = handlerExceptionResolver;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_GESTORE > ROLE_CLIENTE \n ROLE_GESTORE > ROLE_ADDETTO_BAR \n ROLE_GESTORE > ROLE_CASSIERE");
        return roleHierarchy;
    }


    private CorsConfigurationSource corsConfigurationSource() {
        return request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            //the below three lines will add the relevant CORS response headers
            configuration.addAllowedOrigin("*");
            configuration.addAllowedHeader("*");
            configuration.addAllowedMethod("*");
            configuration.setAllowCredentials(true);
            return configuration;
        };
    }

    private SecurityExpressionHandler<FilterInvocation> webExpressionHandler() {
        DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
        return defaultWebSecurityExpressionHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()
                .cors()/*.configurationSource(corsConfigurationSource())todo*/
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(new JwtAuthenticationFilter(authenticationManager(), this.jwtConfig))
                .addFilterAfter(new JwrAuthorizationFilter(this.jwtConfig), JwtAuthenticationFilter.class)
                .addFilterBefore(new GlobalExceptionHandlerFilter(this.handlerExceptionResolver),JwtAuthenticationFilter.class)
                .authorizeRequests()
                .expressionHandler(webExpressionHandler())
                .antMatchers("/infrastruttura/aree/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.POST, "/bar/ordinazioni").hasRole("CLIENTE")
                .antMatchers(HttpMethod.GET, "/bar/ordinazioni/disponibili").hasRole("CLIENTE")
                .antMatchers("/bar/ordinazioni/**").hasAnyRole("ADDETTO_BAR", "CASSIERE")
                .antMatchers(HttpMethod.GET, "/prenotazioni/attivita/disponibili").hasRole("CLIENTE")
                .antMatchers(HttpMethod.POST, "/prenotazioni/attivita").hasRole("CLIENTE")
                .antMatchers("/prenotazioni/attivita/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.GET, "/prenotazioni/ombrelloni/disponibili/{data}/{fasciaOraria}").hasRole("CLIENTE")
                .antMatchers(HttpMethod.POST, "/prenotazioni/ombrelloni").hasRole("CLIENTE")
                .antMatchers("/prenotazioni/ombrelloni/**").hasRole("GESTORE")
                .antMatchers("/catalogo/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.POST, "/utenti").permitAll()
                .antMatchers("/utenti/**").hasRole("GESTORE")
                .antMatchers("/vendite/utente/{idUtente}/da-pagare").hasAnyRole("CLIENTE", "CASSIERE")
                .antMatchers("/vendite/utente/{idUtente}/all").hasAnyRole("CLIENTE", "CASSIERE")
                .antMatchers(HttpMethod.PATCH, "/vendite/{idVendita}/{isPagato}").hasRole("CASSIERE")
                .antMatchers("/vendite/all").hasRole("CASSIERE")
                .antMatchers("/vendite/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.GET,"/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.setStatus(HttpServletResponse.SC_OK))
                .deleteCookies(this.jwtConfig.getCookieName());
    }

}
