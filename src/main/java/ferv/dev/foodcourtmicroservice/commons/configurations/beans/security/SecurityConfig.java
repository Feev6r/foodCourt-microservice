package ferv.dev.foodcourtmicroservice.commons.configurations.beans.security;


import ferv.dev.foodcourtmicroservice.category.domain.models.Role;
import ferv.dev.foodcourtmicroservice.category.infrastructure.security.filters.TokenAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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

                        .requestMatchers("/restaurant/create").hasRole(Role.OWNER.name())
                        .requestMatchers("/restaurant/employee").hasRole(Role.OWNER.name())
                        .requestMatchers("/dish/create").hasRole(Role.OWNER.name())
                        .requestMatchers("/order/create").hasRole(Role.CLIENT.name())
                        .requestMatchers("/order/cancel").hasRole(Role.CLIENT.name())
                        .requestMatchers("/order/sign").hasRole(Role.EMPLOYEE.name())
                        .requestMatchers("/order/getByStateAndRestaurant").hasRole(Role.EMPLOYEE.name())
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
