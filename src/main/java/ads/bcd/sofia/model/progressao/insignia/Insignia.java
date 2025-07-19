package ads.bcd.sofia.model.progressao.insignia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Insignia", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Insignia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInsignia;

    @Column(nullable = false)
    private String nome;

}
