package ads.bcd.sofia.model;

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
    private Acampamento acampamento;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

}
