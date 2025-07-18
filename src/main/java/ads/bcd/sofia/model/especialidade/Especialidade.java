package ads.bcd.sofia.model.especialidade;

import ads.bcd.sofia.model.AreaConhecimento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Especialidade", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Especialidade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidade;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idAreaConhecimento")
    private AreaConhecimento areaDeConhecimento;

}
