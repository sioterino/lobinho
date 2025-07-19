package ads.bcd.sofia.model.progressao.especialidade;

import ads.bcd.sofia.model.pessoa.Jovem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "DesafioEspecialidadeFeita", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesafioEspecialidadeFeita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idDesafioEspecialidade")
    private DesafioEspecialidade desafioEspecialidade;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idJovem")
    private Jovem jovem;

    @Column(nullable = false)
    private LocalDateTime data;

}
