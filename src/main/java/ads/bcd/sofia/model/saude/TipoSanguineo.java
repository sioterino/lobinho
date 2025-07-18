package ads.bcd.sofia.model.saude;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "TipoSanguineo", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoSanguineo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTipoSanguineo")
    private Integer idTipoSanguineo;

    @Column(nullable = false, length = 45)
    private String tipo;

}
