package ads.bcd.sofia.model.saude;

import ads.bcd.sofia.model.pessoa.Jovem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Saude", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}
