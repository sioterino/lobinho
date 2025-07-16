package ads.bcd.sofia.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Vinculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @ManyToOne
    @JoinColumn(name = "idResponsavel", nullable = false)
    private Responsavel responsavel;

    public Vinculo() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Jovem getJovem() {
        return jovem;
    }

    public void setJovem(Jovem jovem) {
        this.jovem = jovem;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    @Override
    public String toString() {
        return "Vinculo{" +
                "id=" + id +
                ", jovem=" + (jovem != null ? jovem.getIdJovem() : "null") +
                ", responsavel=" + (responsavel != null ? responsavel.getIdResponsavel() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vinculo vinculo = (Vinculo) o;

        return Objects.equals(id, vinculo.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
