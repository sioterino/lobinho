package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class DesafioEspecialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafio;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idEspecialidade")
    private Especialidade especialidade;

    @OneToMany(mappedBy = "desafioEspecialidade", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioEspecialidadeFeita> desafiosFeitos;

    public DesafioEspecialidade() {}

    public Integer getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(Integer idDesafio) {
        this.idDesafio = idDesafio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public List<DesafioEspecialidadeFeita> getDesafiosFeitos() {
        return desafiosFeitos;
    }

    public void setDesafiosFeitos(List<DesafioEspecialidadeFeita> desafiosFeitos) {
        this.desafiosFeitos = desafiosFeitos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesafioEspecialidade)) return false;
        DesafioEspecialidade that = (DesafioEspecialidade) o;
        return Objects.equals(idDesafio, that.idDesafio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDesafio);
    }

    @Override
    public String toString() {
        return "DesafioEspecialidade{" +
                "idDesafio=" + idDesafio +
                ", nome='" + nome + '\'' +
                '}';
    }
}
