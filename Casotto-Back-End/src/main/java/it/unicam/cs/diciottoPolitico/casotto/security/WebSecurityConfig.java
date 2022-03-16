package it.unicam.cs.diciottoPolitico.casotto.security;

import it.unicam.cs.diciottoPolitico.casotto.security.jwt.JwrAuthorizationFilter;
import it.unicam.cs.diciottoPolitico.casotto.security.jwt.JwtAuthenticationFilter;
import it.unicam.cs.diciottoPolitico.casotto.security.jwt.JwtConfig;
import it.unicam.cs.diciottoPolitico.casotto.utils.exception.GlobalExceptionHandlerFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.http.HttpServletResponse;

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

    private SecurityExpressionHandler<FilterInvocation> webExpressionHandler() {
        DefaultWebSecurityExpressionHandler defaultWebSecurityExpressionHandler = new DefaultWebSecurityExpressionHandler();
        defaultWebSecurityExpressionHandler.setRoleHierarchy(roleHierarchy());
        return defaultWebSecurityExpressionHandler;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        var cookieRepository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        cookieRepository.setSecure(true);
        http
                .csrf().csrfTokenRepository(cookieRepository)
                .and()
                .cors()
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
                .antMatchers(HttpMethod.GET, "/bar/ordinazioni/all/loggedUser").hasRole("CLIENTE")
                .antMatchers("/bar/ordinazioni/**").hasAnyRole("ADDETTO_BAR", "CASSIERE")
                .antMatchers(HttpMethod.GET, "/prenotazioni/attivita/disponibili").hasRole("CLIENTE")
                .antMatchers(HttpMethod.POST, "/prenotazioni/attivita").hasRole("CLIENTE")
                .antMatchers("/prenotazioni/attivita/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.GET, "/prenotazioni/ombrelloni/disponibili").hasRole("CLIENTE")
                .antMatchers(HttpMethod.POST, "/prenotazioni/ombrelloni").hasRole("CLIENTE")
                .antMatchers("/prenotazioni/ombrelloni/**").hasRole("GESTORE")
                .antMatchers("/catalogo/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.POST, "/utenti").permitAll()
                .antMatchers("/utenti/ruolo").permitAll()
                .antMatchers(HttpMethod.POST,"/utenti").permitAll()
                .antMatchers("/utenti/notifiche").permitAll()
                .antMatchers("/utenti/**").hasRole("GESTORE")
                .antMatchers("/vendite/utente/{idUtente}/da-pagare").hasAnyRole("CLIENTE", "CASSIERE")
                .antMatchers("/vendite/utente/{idUtente}/all").hasAnyRole("CLIENTE", "CASSIERE")
                .antMatchers(HttpMethod.PATCH, "/vendite/{idVendita}/{isPagato}").hasRole("CASSIERE")
                .antMatchers("/vendite/all").hasRole("CASSIERE")
                .antMatchers("/vendite/**").hasRole("GESTORE")
                .antMatchers("/login","/check-token").permitAll()
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> httpServletResponse.setStatus(HttpServletResponse.SC_OK))
                .deleteCookies(this.jwtConfig.getCookieName());
    }

}
