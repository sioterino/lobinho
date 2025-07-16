package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEspecialidade;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idAreaDeConhecimento")
    private AreaConhecimento areaDeConhecimento;

    @OneToMany(mappedBy = "especialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioEspecialidade> desafiosEspecialidade;

    public Integer getIdEspecialidade() {
        return idEspecialidade;
    }

    public void setIdEspecialidade(Integer idEspecialidade) {
        this.idEspecialidade = idEspecialidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public AreaConhecimento getAreaDeConhecimento() {
        return areaDeConhecimento;
    }

    public void setAreaDeConhecimento(AreaConhecimento areaDeConhecimento) {
        this.areaDeConhecimento = areaDeConhecimento;
    }

    public List<DesafioEspecialidade> getDesafiosEspecialidade() {
        return desafiosEspecialidade;
    }

    public void setDesafiosEspecialidade(List<DesafioEspecialidade> desafiosEspecialidade) {
        this.desafiosEspecialidade = desafiosEspecialidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Especialidade)) return false;
        Especialidade that = (Especialidade) o;
        return Objects.equals(idEspecialidade, that.idEspecialidade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEspecialidade);
    }

    @Override
    public String toString() {
        return "Especialidade{" +
                "idEspecialidade=" + idEspecialidade +
                ", nome='" + nome + '\'' +
                '}';
    }
}
