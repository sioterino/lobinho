package ads.bcd.sofia.model.distintivo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "DesafioDistintivo", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesafioDistintivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafioDistintivo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idDistintivo")
    private Distintivo distintivo;

}
