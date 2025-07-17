package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
public class AreaConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaDeConhecimento;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "areaDeConhecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Especialidade> especialidades;

    public AreaConhecimento() {}

}
