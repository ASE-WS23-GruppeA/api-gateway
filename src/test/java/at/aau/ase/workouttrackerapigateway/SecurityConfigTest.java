package at.aau.ase.workouttrackerapigateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class SecurityConfigTest {

  @Autowired
  private WebTestClient webClient;

  @Test
  void testPublicAccess() {
    webClient.get().uri("/actuator/health")
        .exchange()
        .expectStatus().isOk();
  }

  @Test
  void testPrivateAccess() {
    webClient.get().uri("/protected")
        .exchange()
        .expectStatus().isUnauthorized();
  }

  @Test
  void testLogin() {
    webClient.get().uri("/api/auth/login")
        .exchange()
        .expectStatus().is5xxServerError();
  }

  @Test
  void testRegister() {
    webClient.get().uri("/api/auth/register")
        .exchange()
        .expectStatus().is5xxServerError();
  }

}