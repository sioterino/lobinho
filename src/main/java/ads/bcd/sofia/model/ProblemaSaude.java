package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class ProblemaSaude implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProblemaSaude;

    @Column(nullable = false)
    private String tipoProblema;

    private String descricao;

    protected ProblemaSaude() {}

}
