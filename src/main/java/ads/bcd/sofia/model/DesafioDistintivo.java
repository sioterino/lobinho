package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class DesafioDistintivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafioDistintivo;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "idDistintivo")
    private Distintivo distintivo;

    @OneToMany(mappedBy = "desafioDistintivo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioDistintivoFeito> desafiosFeitos;

    public Integer getIdDesafioDistintivo() {
        return idDesafioDistintivo;
    }

    public void setIdDesafioDistintivo(Integer idDesafioDistintivo) {
        this.idDesafioDistintivo = idDesafioDistintivo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Distintivo getDistintivo() {
        return distintivo;
    }

    public void setDistintivo(Distintivo distintivo) {
        this.distintivo = distintivo;
    }

    public List<DesafioDistintivoFeito> getDesafiosFeitos() {
        return desafiosFeitos;
    }

    public void setDesafiosFeitos(List<DesafioDistintivoFeito> desafiosFeitos) {
        this.desafiosFeitos = desafiosFeitos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesafioDistintivo)) return false;
        DesafioDistintivo that = (DesafioDistintivo) o;
        return Objects.equals(idDesafioDistintivo, that.idDesafioDistintivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDesafioDistintivo);
    }

    @Override
    public String toString() {
        return "DesafioDistintivo{" +
                "idDesafioDistintivo=" + idDesafioDistintivo +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
