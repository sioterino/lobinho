package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "AreaConhecimento", schema = "sofiadb")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaConhecimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaConhecimento;

    @Column(nullable = false)
    private String nome;

}
