package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "DesafioInsignia", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DesafioInsignia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafioInsignia;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idInsignia", nullable = false)
    private Insignia insignia;

}
