package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Saude implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @ManyToOne
    @JoinColumn(name = "idProblemaSaude", nullable = false)
    private ProblemaSaude problemaSaude;

    protected Saude() {}

}
