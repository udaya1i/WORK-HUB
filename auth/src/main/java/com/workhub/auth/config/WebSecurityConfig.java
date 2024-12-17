package com.workhub.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((request ->
                                request.requestMatchers(
                                                AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/login"),
                                                AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/"),
                                                AntPathRequestMatcher.antMatcher(HttpMethod.POST, "/logout")
                                        ).permitAll()
                                        .anyRequest().authenticated()
                        )
                );
        return http.build();
    }
}
