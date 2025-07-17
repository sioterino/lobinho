package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class TipoSanguineo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoSanguineo;

    @Column(nullable = false)
    private String tipo;

    protected TipoSanguineo() {}

}
