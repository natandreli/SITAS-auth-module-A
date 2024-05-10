package com.sitas.authmodule.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        return http
//                .csrf(csrf ->
//                        csrf
//                                .disable())
//                .authorizeHttpRequests(authRequest ->
//                        authRequest
//                                .requestMatchers("/auth/**").permitAll()
//                                .anyRequest().authenticated())
//                .formLogin(Customizer.withDefaults())
//                .build();
//    }

    private static final String[] AUTH_WHITELIST = {"/swagger-resources","auth/login", "auth/register", "/swagger-resources/**", "/configuration/ui",
            "/configuration/security", "/swagger-ui.html", "/webjars/**", "/v3/api-docs/**", "v3/api-docs",
            "/api/public/**", "/api/public/authenticate","/public/api/auth/**" ,"/actuator/*", "/swagger-ui/**", "/api-docs/**"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests(authorizeRequests ->
                         authorizeRequests
                              .anyRequest()
                              .permitAll())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
