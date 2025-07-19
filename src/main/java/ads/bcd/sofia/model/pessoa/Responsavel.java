package ads.bcd.sofia.model.pessoa;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "Responsavel", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsavel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResponsavel;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 45)
    private String telefone;

    @Column(nullable = false, length = 255)
    private String email;

}
