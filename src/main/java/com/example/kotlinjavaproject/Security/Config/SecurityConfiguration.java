package com.example.kotlinjavaproject.Security.Config;

import com.example.kotlinjavaproject.Business.Constants.ApiRequest.ApiUrl;
import com.example.kotlinjavaproject.Security.Models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {


private final JwtAuthenticationFilter jwtAuthFilter;
private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers(ApiUrl.AUTHENTICATION_API).permitAll()
                .requestMatchers(HttpMethod.GET, ApiUrl.BOOKS_API).permitAll()
                .requestMatchers(HttpMethod.GET,ApiUrl.AUTHORS_API).permitAll()
                .requestMatchers(HttpMethod.GET,ApiUrl.CATEGORIES_API).permitAll()
                .requestMatchers(HttpMethod.POST,ApiUrl.BOOKS_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.POST,ApiUrl.AUTHORS_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.POST,ApiUrl.CATEGORIES_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.PUT,ApiUrl.BOOKS_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.PUT,ApiUrl.AUTHORS_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.PUT,ApiUrl.CATEGORIES_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE,ApiUrl.BOOKS_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE,ApiUrl.AUTHORS_API).hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE,ApiUrl.CATEGORIES_API).hasRole(Role.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(this.authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
