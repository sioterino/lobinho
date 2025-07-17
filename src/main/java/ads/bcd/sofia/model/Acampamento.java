package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Data
public class Acampamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcampamento;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "acampamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoiteAcampada> noitesAcampadas;

    public Acampamento() {}

}
