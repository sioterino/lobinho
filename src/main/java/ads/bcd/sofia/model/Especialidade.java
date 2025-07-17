package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidade;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idAreaDeConhecimento")
    private AreaConhecimento areaDeConhecimento;

    @OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioEspecialidade> desafiosEspecialidade;

    public Especialidade() {}

}
