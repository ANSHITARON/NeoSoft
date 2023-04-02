package com.security.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsService userDetailsService(){
       UserDetails normal= User.builder().username("ankit").password(passwordEncoder().encode("ankit")).roles("NORMAL").build();

       UserDetails admin= User.builder().username("anshit").password(passwordEncoder().encode("anshit")).roles("ADMIN").build();


       return new InMemoryUserDetailsManager(normal, admin);
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
