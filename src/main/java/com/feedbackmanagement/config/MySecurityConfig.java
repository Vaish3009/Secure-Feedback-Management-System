package com.feedbackmanagement.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class MySecurityConfig {
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		

		
		httpSecurity.csrf().disable()
		       .authorizeRequests()
		       .anyRequest()
		       .authenticated()
		       .and()
		       .httpBasic();
		
		return httpSecurity.build();
	 }
}
