package it.unicam.cs.diciottoPolitico.casotto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
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
        http.httpBasic()
                .and()
                .csrf().disable()
                .authorizeRequests()
                .expressionHandler(webExpressionHandler())
                .antMatchers("/infrastruttura/aree/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.POST,"/bar/ordinazioni").hasRole("CLIENTE")
                .antMatchers(HttpMethod.GET,"/bar/ordinazioni/disponibili").hasRole("CLIENTE")
                .antMatchers("/bar/ordinazioni/**").hasAnyRole("ADDETTO_BAR","CASSIERE")
                .antMatchers(HttpMethod.GET,"/prenotazioni/attivita/disponibili").hasRole("CLIENTE")
                .antMatchers(HttpMethod.POST,"/prenotazioni/attivita").hasRole("CLIENTE")
                .antMatchers("/prenotazioni/attivita/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.GET,"/prenotazioni/ombrelloni/disponibili/{data}/{fasciaOraria}").hasRole("CLIENTE")
                .antMatchers(HttpMethod.POST,"/prenotazioni/ombrelloni").hasRole("CLIENTE")
                .antMatchers("/prenotazioni/ombrelloni/**").hasRole("GESTORE")
                .antMatchers("/catalogo/**").hasRole("GESTORE")
                .antMatchers(HttpMethod.POST,"/utenti").permitAll()
                .antMatchers("/utenti/**").hasRole("GESTORE")
                .antMatchers("/vendite/{idUtente}").hasAnyRole("CLIENTE","CASSIERE")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
    }
}
