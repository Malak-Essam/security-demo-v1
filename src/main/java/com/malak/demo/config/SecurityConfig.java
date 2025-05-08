package com.malak.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.builder()
				.username("user")
				.password(passwordEncoder().encode("password123"))
				.roles("USER")
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password(passwordEncoder().encode("admin"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/api/v1/public/**").permitAll()
					.requestMatchers("/api/v1/user/**").hasRole("USER")
					.requestMatchers("/api/v1/admin/**").hasRole("ADMIN")
					.anyRequest().authenticated()
					)
			.formLogin(form -> form.permitAll()
					)
			.logout(logout -> logout
					.logoutSuccessUrl("/login?logout")
					.permitAll()
					);
			
			return http.build();
	}
}
