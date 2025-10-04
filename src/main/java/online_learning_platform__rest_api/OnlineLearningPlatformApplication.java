package online_learning_platform__rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class OnlineLearningPlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineLearningPlatformApplication.class, args);
    }

}
