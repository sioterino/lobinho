package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "ProblemaSaude", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProblemaSaude implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProblemaSaude;

    @Column(nullable = false)
    private String tipoProblema;

    private String descricao;

}
