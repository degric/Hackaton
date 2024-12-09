package com.api.login.security;

import com.api.login.security.jwt.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.time.Duration;
import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomerDetailsService customerDetailsService;

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    protected SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors()
                .configurationSource(corsConfigurationSource())
                //request -> new CorsConfiguration().applyPermitDefaultValues()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/user/login","/user/signup","/user/forgotPassword","/imagenreclamo")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().exceptionHandling()
                .and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

    /*
    @Bean
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.cors(withDefaults())
                .csrf().disable().authorizeHttpRequests()
                .dispatcherTypeMatchers(HttpMethod.valueOf("/billing/**")).authenticated()
                .and()
                .httpBasic();
    }
*/
    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration authenticationConfiguration) throws Exception{

        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(){

        /*
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*")); // Permitir cualquier origen
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")); // Permitir varios métodos HTTP
        configuration.setAllowedHeaders(Arrays.asList("Origin", "Accept", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization")); // Permitir varios encabezados
        configuration.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")); // Exponer ciertos encabezados
        configuration.setAllowCredentials(true); // Permitir el envío de credenciales
        configuration.setMaxAge(Duration.ofSeconds(3600)); // Configurar el tiempo máximo de caché para las solicitudes preflight
        configuration.addAllowedHeader("http://localhost:5173/");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;


        Origin", "Accept", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization
        Origin,Accept", "X-Requested-With", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers","Authorization
         */

        CorsConfiguration cc = new CorsConfiguration();
        cc.setAllowedHeaders(Arrays.asList("Origin", "Accept", "Content-Type", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization"));
        cc.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        cc.setAllowedOrigins(Arrays.asList("/*"));
        cc.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "PUT","PATCH", "DELETE"));
        cc.addAllowedOrigin("http://localhost:5173/");
        cc.setMaxAge(Duration.ZERO);
        cc.setAllowCredentials(Boolean.TRUE);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",cc);
        return source;

    }
}
