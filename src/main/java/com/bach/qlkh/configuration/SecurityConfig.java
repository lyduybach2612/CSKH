package com.bach.qlkh.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final String[] PERMIT_ALL = {"/products", "/customers/new"};
    private final CustomUserServiceDetail customUserServiceDetail;

    public SecurityConfig(CustomUserServiceDetail customUserServiceDetail) {
        this.customUserServiceDetail = customUserServiceDetail;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                                .requestMatchers(PERMIT_ALL).permitAll()
                                .requestMatchers("/customers/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                        )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/products")
                        .loginProcessingUrl("/login")
                        .failureUrl("/login?fail")
                        .permitAll())
                .logout(logout->logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")));
        return http.build();

    }

    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(customUserServiceDetail).passwordEncoder(passwordEncoder());
    }

}
