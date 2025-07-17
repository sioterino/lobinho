package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class DesafioInsigniaFeita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idDesafio", nullable = false)
    private DesafioInsignia desafioInsignia;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @Column(nullable = false)
    private LocalDateTime data;

    protected DesafioInsigniaFeita() {}

}
