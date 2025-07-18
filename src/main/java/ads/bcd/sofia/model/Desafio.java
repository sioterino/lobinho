package ads.bcd.sofia.model;

import ads.bcd.sofia.model.insignia.Insignia;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Desafio", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Desafio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafio;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idInsignia")
    private Insignia insignia;

}
