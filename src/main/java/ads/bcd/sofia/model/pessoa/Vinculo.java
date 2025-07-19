package ads.bcd.sofia.model.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Vinculo", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vinculo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVinculo;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @ManyToOne
    @JoinColumn(name = "idResponsavel", nullable = false)
    private Responsavel responsavel;
}

