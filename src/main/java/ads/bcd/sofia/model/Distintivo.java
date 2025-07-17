package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Distintivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistintivo;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "distintivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioDistintivo> desafiosDistintivo;

    protected Distintivo() {}

}
