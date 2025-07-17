package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class AreaConhecimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaDeConhecimento;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "areaDeConhecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Especialidade> especialidades;

    protected AreaConhecimento() {}

}
