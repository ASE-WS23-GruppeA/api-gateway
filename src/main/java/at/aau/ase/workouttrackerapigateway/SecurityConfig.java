package at.aau.ase.workouttrackerapigateway;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.jwt.ReactiveJwtDecoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    http
        .csrf(ServerHttpSecurity.CsrfSpec::disable)
        .authorizeExchange(authorizeExchangeSpec -> authorizeExchangeSpec
            // TODO (Timo Tabertshofer, 02.11.2023): remove unused routes
            .pathMatchers("/headerrouting/**").permitAll()
            .pathMatchers("/actuator/**").permitAll()
            .pathMatchers("/eureka/**").permitAll()
            .pathMatchers("/oauth2/**").permitAll()
            .pathMatchers("/login/**").permitAll()
            .pathMatchers("/api/auth/login").permitAll()
            .pathMatchers("/api/auth/register").permitAll()
            .pathMatchers("/error/**").permitAll()
            .pathMatchers("/openapi/**").permitAll()
            .pathMatchers("/webjars/**").permitAll()
            .anyExchange().authenticated()
        )
        .oauth2ResourceServer(oAuth2ResourceServerSpec -> oAuth2ResourceServerSpec
            .jwt(withDefaults())
        );

    return http.build();
  }

}
