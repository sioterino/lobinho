package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
public class DesafioDistintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafioDistintivo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idDistintivo")
    private Distintivo distintivo;

    @OneToMany(mappedBy = "desafioDistintivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioDistintivoFeito> desafiosFeitos;

    public DesafioDistintivo() {}

}
