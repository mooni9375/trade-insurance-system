package com.tradeinsurance.apigatewayservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class SecurityConfig {

//    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        http
//                .csrf(ServerHttpSecurity.CsrfSpec::disable) // CSRF 비활성화
//                .authorizeExchange(exchange -> exchange
//                        .pathMatchers("/actuator/**").permitAll() // Actuator 엔드포인트 인증 없이 접근 허용
//                        .anyExchange().authenticated() // 나머지는 인증 필요
//                );
//
//        return http.build();
//    }
}
