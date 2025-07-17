package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Distintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistintivo;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "distintivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioDistintivo> desafiosDistintivo;

    public Distintivo() {}

}
