package ads.bcd.sofia;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories("ads.bcd.sofia.repository")
@EntityScan("ads.bcd.sofia.model")
public class Application {

    @Autowired
    private App app;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public CommandLineRunner runApp() {
        return (args) -> {
            try {
                app.landingPage();
            } catch (Exception e) {
                log.error("Erro: ", e);
            }
        };
    }
}
