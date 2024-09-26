package com.FullStack.ms_transaction.infrastructure.security;

import com.FullStack.ms_transaction.infrastructure.security.jwt.JwtEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static com.FullStack.ms_transaction.infrastructure.security.utils.ConstantsSecurity.SUPPLIES_CONTROLLER_POST_ADD_SUPPLIES;
import static com.FullStack.ms_transaction.infrastructure.security.utils.ConstantsSecurity.SWAGGER_UI;
import static com.FullStack.ms_transaction.infrastructure.security.utils.ConstantsSecurity.SWAGGER_UI_HTML;
import static com.FullStack.ms_transaction.infrastructure.security.utils.ConstantsSecurity.V3_API_DOCS;
import static com.FullStack.ms_transaction.infrastructure.security.utils.ConstantsSecurity.WAREHOUSE_ASSISTANT_ROLE;

@Configuration
@EnableWebSecurity
public class WebSecurity {

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception{
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(){
        return new JwtAuthenticationFilter();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(SWAGGER_UI_HTML, SWAGGER_UI, V3_API_DOCS).permitAll()
                        .requestMatchers(HttpMethod.POST, SUPPLIES_CONTROLLER_POST_ADD_SUPPLIES).hasAuthority(WAREHOUSE_ASSISTANT_ROLE)
                        .anyRequest().authenticated()

                )
                .formLogin(formLogin -> formLogin.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtEntryPoint))
                .addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
