package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "DesafioInsigniaFeita", schema = "sofiadb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DesafioInsigniaFeita implements  Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idDesafioInsignia", nullable = false)
    private DesafioInsignia desafioInsignia;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @Column(nullable = false)
    private LocalDateTime data;

}
