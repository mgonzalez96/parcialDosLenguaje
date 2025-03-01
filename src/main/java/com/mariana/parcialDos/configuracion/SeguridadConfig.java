package com.mariana.parcialDos.configuracion;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableAutoConfiguration
public class SeguridadConfig {
	
	/*
	 * método Bean para permitir el acceso sin logueo de los endpoints
	 */
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 🔴 Desactiva CSRF para permitir POST, PUT y DELETE en Postman
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(Customizer.withDefaults()) // 🔑 Habilita autenticación básica
            .formLogin(Customizer.withDefaults()); // 📝 Habilita formulario de login

        return http.build();
    }

	/*
	 * método Bean para configurar los usuarios de logueo
	 */
    @Bean
    MapReactiveUserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("user")
            .password("password") // 🔑 Cifra la contraseña con BCrypt
            .roles("USER")
            .build();

        return new MapReactiveUserDetailsService(user);
    }
    
	/*
	 * método Bean para tomar el archivo .properties de
	 * donde va a obtener los mensajes
	 */
	@Bean
	MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

}
