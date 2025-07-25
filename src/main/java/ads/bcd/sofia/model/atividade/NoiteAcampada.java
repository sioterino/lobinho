package ads.bcd.sofia.model.atividade;

import ads.bcd.sofia.model.pessoa.Jovem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "NoiteAcampada", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoiteAcampada implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idAcampamento", nullable = false)
    private Acampamentos acampamentos;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

}
