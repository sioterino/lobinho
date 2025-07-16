package ads.bcd.sofia.model;

import jakarta.persistence.*;

@Entity
public class Saude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @ManyToOne
    @JoinColumn(name = "idProblemaSaude", nullable = false)
    private ProblemaSaude problemaSaude;

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

    public ProblemaSaude getProblemaSaude() {
        return problemaSaude;
    }

    public void setProblemaSaude(ProblemaSaude problemaSaude) {
        this.problemaSaude = problemaSaude;
    }

    @Override
    public String toString() {
        return "Saude{" +
                "id=" + id +
                ", jovem=" + (jovem != null ? jovem.getIdJovem() : "null") +
                ", problemaSaude=" + (problemaSaude != null ? problemaSaude.getIdProblemaSaude() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Saude)) return false;
        Saude saude = (Saude) o;
        return id != null && id.equals(saude.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
