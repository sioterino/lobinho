package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class DesafioEspecialidadeFeita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idDesafio", nullable = false)
    private DesafioEspecialidade desafioEspecialidade;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @Column(nullable = false)
    private LocalDateTime data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DesafioEspecialidade getDesafioEspecialidade() {
        return desafioEspecialidade;
    }

    public void setDesafioEspecialidade(DesafioEspecialidade desafioEspecialidade) {
        this.desafioEspecialidade = desafioEspecialidade;
    }

    public Jovem getJovem() {
        return jovem;
    }

    public void setJovem(Jovem jovem) {
        this.jovem = jovem;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesafioEspecialidadeFeita)) return false;
        DesafioEspecialidadeFeita that = (DesafioEspecialidadeFeita) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "DesafioEspecialidadeFeita{" +
                "id=" + id +
                ", desafioEspecialidade=" + desafioEspecialidade +
                ", jovem=" + jovem +
                ", data=" + data +
                '}';
    }
}
