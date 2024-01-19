package at.aau.ase.workouttrackerapigateway;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

  @Bean
  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    http
        .csrf(ServerHttpSecurity.CsrfSpec::disable)
        .authorizeExchange(exchangeSpec -> exchangeSpec
            .pathMatchers("/actuator/**").permitAll()
            .pathMatchers("/api/auth/login").permitAll()
            .pathMatchers("/api/auth/register").permitAll()
            .anyExchange().authenticated()
        )
        .oauth2ResourceServer(resourceServerSpec -> resourceServerSpec
            .jwt(withDefaults())
        );

    return http.build();
  }

}
