package ads.bcd.sofia.model.progressao.distintivo;

import ads.bcd.sofia.model.pessoa.Jovem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "DesafioDistintivoFeita", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesafioDistintivoFeita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idDesafioDistintivo", nullable = false)
    private DesafioDistintivo desafioDistintivo;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

}
