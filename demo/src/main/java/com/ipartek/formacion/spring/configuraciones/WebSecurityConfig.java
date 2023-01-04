package com.ipartek.formacion.spring.configuraciones;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	// AUTORIZACIÓN
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
                )
                .formLogin(form -> form
                                //.loginPage("/login")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    // AUTENTICACIÓN
	@Bean
	UserDetailsService userDetailsService() {
		UserDetails admin =
			 User.withDefaultPasswordEncoder()
				.username("admin")
				.password("contra")
				.roles("ADMIN")
				.build();
		
		UserDetails usuario =
				 User.withDefaultPasswordEncoder()
					.username("pepe")
					.password("perez")
					.roles("USER")
					.build();

		return new InMemoryUserDetailsManager(admin,usuario);
	}
}
