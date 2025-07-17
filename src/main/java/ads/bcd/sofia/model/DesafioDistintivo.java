package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class DesafioDistintivo implements Serializable {

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

    protected DesafioDistintivo() {}

}
