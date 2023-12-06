package at.aau.ase.workouttrackerapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class WorkoutTrackerApiGatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(WorkoutTrackerApiGatewayApplication.class, args);
  }

}
