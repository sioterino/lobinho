package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Saude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @ManyToOne
    @JoinColumn(name = "idProblemaSaude", nullable = false)
    private ProblemaSaude problemaSaude;

    public Saude() {}

}
