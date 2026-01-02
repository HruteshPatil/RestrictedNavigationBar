package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(auth -> auth
				// Fix 1: Use wildcards for CSS and remove direct template access
				.requestMatchers("/", "/login","/data", "/css/**","/reactive" ,"/js/**").permitAll()
				
				// Fix 2: Remove "ROLE_" prefix when using .hasRole()
				.requestMatchers("/Admin/**").hasRole("ADMIN")
				.requestMatchers("/mod/**").hasRole("MODERATOR")
				.anyRequest().authenticated()
				)
		
		.formLogin(form -> form
				.loginPage("/login")
				// Fix 3: Redirect to home, not back to login
				.defaultSuccessUrl("/", true)
				.permitAll()
				)
		
		.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.invalidateHttpSession(true)
				.permitAll()
				)
		
		// Note: Keeping CSRF disabled as per your request, 
		// but remember to enable it for production!
		.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
}