package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Acampamento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcampamento;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "acampamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoiteAcampada> noitesAcampadas;

    protected Acampamento() {}

}
