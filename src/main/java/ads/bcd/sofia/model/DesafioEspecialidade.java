package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class DesafioEspecialidade implements Serializable {

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

    protected DesafioEspecialidade() {};

}
