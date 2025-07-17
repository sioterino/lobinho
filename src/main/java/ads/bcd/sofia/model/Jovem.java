package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Jovem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJovem;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime dataNascimento;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "idTipoSanguineo")
    private TipoSanguineo tipoSanguineo;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vinculo> vinculos;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Saude> problemasDeSaude;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoiteAcampada> noitesAcampadas;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioInsigniaFeita> desafiosInsigniaFeitos;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioEspecialidadeFeita> desafiosEspecialidadeFeitos;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioDistintivoFeito> desafiosDistintivoFeitos;

    protected Jovem() {}

}
