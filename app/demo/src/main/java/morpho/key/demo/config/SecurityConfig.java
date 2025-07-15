package morpho.key.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {  //use for BCrypt for passwords
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // desactiva CSRF para pruebas
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/user/test").permitAll() // permite acceder sin autenticación
                        .anyRequest().authenticated()
                ).httpBasic(httpBasic -> {});

        return http.build();
    }
*/

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())               // desactiva protección CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()               // permite TODO sin autenticación
                )
                .httpBasic(httpBasic -> {});                // necesario en Spring Security 6+

        return http.build();
    }
}
