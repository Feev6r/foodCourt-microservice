package ferv.dev.foodcourtmicroservice.commons.configurations.beans.security;


import ferv.dev.foodcourtmicroservice.category.domain.models.Role;
import ferv.dev.foodcourtmicroservice.category.infrastructure.security.filters.TokenAuthenticationFilter;
import ferv.dev.foodcourtmicroservice.commons.configurations.utils.constants.ApiPaths;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final TokenAuthenticationFilter tokenAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize
                        //.requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .requestMatchers(HttpMethod.GET, ApiPaths.RESTAURANTS).permitAll()
                        .requestMatchers(HttpMethod.POST, ApiPaths.RESTAURANTS).hasRole(Role.ADMIN.name())

                        .requestMatchers(HttpMethod.POST, ApiPaths.DISHES).hasRole(Role.OWNER.name())
                        .requestMatchers(HttpMethod.PUT, ApiPaths.DISHES).hasRole(Role.OWNER.name())
                        .requestMatchers(HttpMethod.GET, ApiPaths.DISHES).hasRole(Role.EMPLOYEE.name())

                        .requestMatchers(HttpMethod.POST, ApiPaths.ORDERS).hasRole(Role.CLIENT.name())
                        .requestMatchers(HttpMethod.GET, ApiPaths.ORDERS).hasRole(Role.EMPLOYEE.name())


                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .addFilterBefore(tokenAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
                );

        return http.build();
    }

}
