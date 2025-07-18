package ads.bcd.sofia;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import ads.bcd.sofia.model.*;
import ads.bcd.sofia.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Slf4j
@SpringBootApplication
@EnableJpaRepositories("ads.bcd.sofia.repository")
@EntityScan("ads.bcd.sofia.model")
public class Application {

    @Autowired
    private TipoSanguineoRepository tipoSanguineoRepository;

    @Autowired
    private JovemRepository jovemRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private VinculoRepository vinculoRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("Aplicação finalizada");
    }

    private void populateDatabase() throws Exception {

    }


    private void listRecords() throws Exception {
        System.out.println("------ Tipo Sanguíneo ------");
        tipoSanguineoRepository.findAll().forEach(System.out::println);

        System.out.println("------ Jovens ------");
        jovemRepository.findAll().forEach(System.out::println);

        System.out.println("------ Responsáveis ------");
        responsavelRepository.findAll().forEach(System.out::println);

        System.out.println("------ Vínculos ------");
        vinculoRepository.findAll().forEach(System.out::println);

        System.out.println("------ Buscar Jovens por Tipo Sanguíneo A+ ------");
        Optional<TipoSanguineo> tipoA = tipoSanguineoRepository.findByTipo("A+");
        tipoA.ifPresent(tipo -> {
            jovemRepository.findByTipoSanguineo(tipo).forEach(System.out::println);
        });
    }

    @Bean
    public CommandLineRunner runApp() {
        return (args) -> {
            try {
                log.info("Iniciando aplicação");
//                this.populateDatabase();
                this.listRecords();
            } catch (Exception e) {
                log.error("Erro: ", e);
            }
        };
    }
}
