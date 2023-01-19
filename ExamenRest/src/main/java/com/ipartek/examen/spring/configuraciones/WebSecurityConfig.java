package com.ipartek.examen.spring.configuraciones;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	

	@Autowired
	DataSource dataSource;
	
	@Bean
	PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	// AUTORIZACIÓN
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                                .requestMatchers("/admin/**").hasRole("ADMIN")
                                .requestMatchers("/confirmacion").authenticated()
                                .anyRequest().permitAll()
                )
                .formLogin(form -> form
                                .loginPage("/login")
                                .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }
    
    @Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth, @Lazy PasswordEncoder passwordEncoder)
	  throws Exception {
		 auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery("select email,password,true "
		            + "from usuarios "
		            + "where email = ?")
			.authoritiesByUsernameQuery("select u.email, CONCAT('ROLE_', r.nombre) "
		      		+ "from usuarios u "
		      		+ "join roles r on r.id = u.rol_id "
		      		+ "where email = ?").passwordEncoder(passwordEncoder);
	}


}
