package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class AreaConhecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAreaDeConhecimento;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "areaDeConhecimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Especialidade> especialidades;

    public Integer getIdAreaDeConhecimento() {
        return idAreaDeConhecimento;
    }

    public void setIdAreaDeConhecimento(Integer idAreaDeConhecimento) {
        this.idAreaDeConhecimento = idAreaDeConhecimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Especialidade> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidade> especialidades) {
        this.especialidades = especialidades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AreaConhecimento)) return false;
        AreaConhecimento that = (AreaConhecimento) o;
        return Objects.equals(idAreaDeConhecimento, that.idAreaDeConhecimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAreaDeConhecimento);
    }

    @Override
    public String toString() {
        return "AreaConhecimento{" +
                "idAreaDeConhecimento=" + idAreaDeConhecimento +
                ", nome='" + nome + '\'' +
                '}';
    }
}
