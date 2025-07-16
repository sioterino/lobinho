package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Acampamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAcampamento;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "acampamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoiteAcampada> noitesAcampadas;

    public Acampamento() {}

    public Integer getIdAcampamento() {
        return idAcampamento;
    }

    public void setIdAcampamento(Integer idAcampamento) {
        this.idAcampamento = idAcampamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public List<NoiteAcampada> getNoitesAcampadas() {
        return noitesAcampadas;
    }

    public void setNoitesAcampadas(List<NoiteAcampada> noitesAcampadas) {
        this.noitesAcampadas = noitesAcampadas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Acampamento)) return false;
        Acampamento that = (Acampamento) o;
        return Objects.equals(idAcampamento, that.idAcampamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAcampamento);
    }

    @Override
    public String toString() {
        return "Acampamento{" +
                "idAcampamento=" + idAcampamento +
                ", nome='" + nome + '\'' +
                ", data=" + data +
                '}';
    }
}
