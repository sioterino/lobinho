package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class NoiteAcampada {

    @Id
    @ManyToOne
    @JoinColumn(name = "idAcampamento", nullable = false)
    private Acampamento acampamento;

    @Id
    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    // Constructors, getters, setters

    public Acampamento getAcampamento() {
        return acampamento;
    }

    public void setAcampamento(Acampamento acampamento) {
        this.acampamento = acampamento;
    }

    public Jovem getJovem() {
        return jovem;
    }

    public void setJovem(Jovem jovem) {
        this.jovem = jovem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NoiteAcampada)) return false;
        NoiteAcampada that = (NoiteAcampada) o;
        return Objects.equals(acampamento, that.acampamento) &&
                Objects.equals(jovem, that.jovem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acampamento, jovem);
    }

    @Override
    public String toString() {
        return "NoiteAcampada{" +
                "acampamento=" + acampamento +
                ", jovem=" + jovem +
                '}';
    }
}
