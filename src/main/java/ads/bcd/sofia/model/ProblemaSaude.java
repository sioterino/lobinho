package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ProblemaSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProblemaSaude;

    @Column(nullable = false)
    private String tipoProblema;

    private String descricao;

    public ProblemaSaude() {}

}
