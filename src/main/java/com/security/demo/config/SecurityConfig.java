package com.security.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig {
        @Autowired
    private MongoUserDetailsService MongouserDetailsService;
   // @Bean
   // public UserDetailsService userDetailsService(){
    //   UserDetails normal= User.builder().username("ankit").password(passwordEncoder().encode("ankit")).roles("NORMAL").build();

     // UserDetails admin= User.builder().username("anshit").password(passwordEncoder().encode("anshit")).roles("ADMIN").build();


    //   return new InMemoryUserDetailsManager(normal, admin);
    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(this.MongouserDetailsService);
       daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
