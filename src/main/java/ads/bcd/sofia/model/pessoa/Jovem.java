package ads.bcd.sofia.model.pessoa;

import ads.bcd.sofia.model.saude.TipoSanguineo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Jovem", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jovem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJovem;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime dataNascimento;

    @Column(nullable = false, length = 45)
    private String telefone;

    @Column(nullable = false, length = 255)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idTipoSanguineo", nullable = false)
    private TipoSanguineo tipoSanguineo;

}
