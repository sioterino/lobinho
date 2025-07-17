package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
public class DesafioEspecialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafio;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idEspecialidade")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "desafioEspecialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioEspecialidadeFeita> desafiosFeitos;

    public DesafioEspecialidade() {};

}
