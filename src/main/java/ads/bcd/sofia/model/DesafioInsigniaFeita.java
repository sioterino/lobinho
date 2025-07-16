package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class DesafioInsigniaFeita {

    @Id
    @ManyToOne
    @JoinColumn(name = "idDesafio", nullable = false)
    private DesafioInsignia desafioInsignia;

    @Id
    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @Column(nullable = false)
    private LocalDateTime data;

    // Getters and setters

    public DesafioInsignia getDesafioInsignia() {
        return desafioInsignia;
    }

    public void setDesafioInsignia(DesafioInsignia desafioInsignia) {
        this.desafioInsignia = desafioInsignia;
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

    // equals and hashCode using both PKs

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesafioInsigniaFeita)) return false;
        DesafioInsigniaFeita that = (DesafioInsigniaFeita) o;
        return Objects.equals(desafioInsignia, that.desafioInsignia) &&
                Objects.equals(jovem, that.jovem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desafioInsignia, jovem);
    }

    @Override
    public String toString() {
        return "DesafioInsigniaFeita{" +
                "desafioInsignia=" + desafioInsignia +
                ", jovem=" + jovem +
                ", data=" + data +
                '}';
    }
}
