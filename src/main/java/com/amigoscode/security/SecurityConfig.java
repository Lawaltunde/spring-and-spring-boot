package com.amigoscode.security;

// TODO: 19 - Create a SecurityFilterChain bean:
//  - Annotate this class with @Configuration and @EnableWebSecurity
//  - Create a @Bean method that returns SecurityFilterChain
//  - Configure HTTP Basic authentication
//  - Permit access to /h2-console/** and /actuator/**
//  - Require authentication for all other endpoints
//  Hint:
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//            .csrf(csrf -> csrf.disable())
//            .headers(headers -> headers.frameOptions(f -> f.disable()))
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/h2-console/**", "/actuator/**").permitAll()
//                .anyRequest().authenticated()
//            )
//            .httpBasic(Customizer.withDefaults())
//            .build();
//    }

// TODO: 20 - Create an in-memory user:
//  - Create a @Bean method that returns UserDetailsService
//  - Use User.builder() to create a user with username "admin", password "password", role "ADMIN"
//  - Use BCryptPasswordEncoder to encode the password
//  - Return new InMemoryUserDetailsManager(user)
//  - Also create a @Bean for PasswordEncoder returning new BCryptPasswordEncoder()
public class SecurityConfig {

}
