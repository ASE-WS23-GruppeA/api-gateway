package at.aau.ase.workouttrackerapigateway;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WorkoutTrackerApiGatewayApplicationTests {

  @Autowired
  private WebTestClient webClient;

  @Test
  void contextLoads() {
    webClient
        .get().uri("/get")
        .exchange()
        .expectStatus().isOk()
        .expectBody()
        .jsonPath("$.headers.Hello").isEqualTo("World");
  }

}
