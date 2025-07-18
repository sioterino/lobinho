package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class DesafioInsignia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafio;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idInsignia", nullable = false)
    private Insignia insignia;

    @OneToMany(mappedBy = "desafioInsignia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioInsigniaFeita> completacoes;

    protected DesafioInsignia() {}

}
