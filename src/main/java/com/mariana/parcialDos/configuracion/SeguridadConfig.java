package com.mariana.parcialDos.configuracion;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableAutoConfiguration
public class SeguridadConfig {

	//Maneja la seguridad de la aplicación, permite que si la ruta es publico ingrese sin loguearse, 
    //para otras rutas solicita logueo
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                            .authorizeRequests()
                            .requestMatchers("/api/v1/saludo").permitAll()
                            .anyRequest().authenticated()
                            .and()
                            .formLogin().and().httpBasic();

            return http.build();
    }
    
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
    
}
