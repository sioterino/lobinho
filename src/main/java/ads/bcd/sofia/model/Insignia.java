package ads.bcd.sofia.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
public class Insignia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInsignia;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "insignia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioInsignia> desafios;

    protected Insignia() {}

}
