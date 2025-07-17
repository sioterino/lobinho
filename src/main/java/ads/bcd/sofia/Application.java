package ads.bcd.sofia;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ads.bcd.sofia.model.*;
import ads.bcd.sofia.repository.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
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
        // Create blood types using constructor
        TipoSanguineo tipoA = new TipoSanguineo(null, "A+");
        TipoSanguineo tipoB = new TipoSanguineo(null, "B+");

        tipoSanguineoRepository.save(tipoA);
        tipoSanguineoRepository.save(tipoB);

        // Create Jovens using constructor
        Jovem jovem1 = new Jovem(
                null,
                "Lucas Silva",
                LocalDateTime.of(2005, 5, 15, 0, 0),
                "123456789",
                "lucas@email.com",
                tipoA,
                null,
                null,
                null,
                null,
                null,
                null
        );

        Jovem jovem2 = new Jovem(
                null,
                "Maria Souza",
                LocalDateTime.of(2006, 8, 20, 0, 0),
                "987654321",
                "maria@email.com",
                tipoB,
                null,
                null,
                null,
                null,
                null,
                null
        );

        jovemRepository.save(jovem1);
        jovemRepository.save(jovem2);

        // Create Responsável using constructor
        Responsavel responsavel1 = new Responsavel(
                null,
                "João Silva",
                "5551234",
                "joao@email.com",
                null // vínculos
        );

        responsavelRepository.save(responsavel1);

        // Create Vínculo using constructor
        Vinculo vinculo = new Vinculo(null, jovem1, responsavel1);

        vinculoRepository.save(vinculo);
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
                this.populateDatabase();
                this.listRecords();
            } catch (Exception e) {
                log.error("Erro: ", e);
            }
        };
    }
}
