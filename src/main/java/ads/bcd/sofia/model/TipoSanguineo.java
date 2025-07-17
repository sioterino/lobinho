package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class TipoSanguineo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoSanguineo;

    @Column(nullable = false)
    private String tipo;

    public TipoSanguineo() {}

}
