package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Distintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDistintivo;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "distintivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioDistintivo> desafiosDistintivo;

    public Distintivo() {}

    public Integer getIdDistintivo() {
        return idDistintivo;
    }

    public void setIdDistintivo(Integer idDistintivo) {
        this.idDistintivo = idDistintivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<DesafioDistintivo> getDesafiosDistintivo() {
        return desafiosDistintivo;
    }

    public void setDesafiosDistintivo(List<DesafioDistintivo> desafiosDistintivo) {
        this.desafiosDistintivo = desafiosDistintivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Distintivo)) return false;
        Distintivo that = (Distintivo) o;
        return Objects.equals(idDistintivo, that.idDistintivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDistintivo);
    }

    @Override
    public String toString() {
        return "Distintivo{" +
                "idDistintivo=" + idDistintivo +
                ", nome='" + nome + '\'' +
                '}';
    }
}
