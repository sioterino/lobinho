package ads.bcd.sofia.model.distintivo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "Distintivo", schema = "sofiadb")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Distintivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistintivo;

    @Column(nullable = false)
    private String nome;

}
