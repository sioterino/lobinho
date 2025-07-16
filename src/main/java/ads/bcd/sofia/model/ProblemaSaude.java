package ads.bcd.sofia.model;

import jakarta.persistence.*;

@Entity
public class ProblemaSaude {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProblemaSaude;

    @Column(nullable = false)
    private String tipoProblema;

    private String descricao;

    public Integer getIdProblemaSaude() {
        return idProblemaSaude;
    }

    public void setIdProblemaSaude(Integer idProblemaSaude) {
        this.idProblemaSaude = idProblemaSaude;
    }

    public String getTipoProblema() {
        return tipoProblema;
    }

    public void setTipoProblema(String tipoProblema) {
        this.tipoProblema = tipoProblema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ProblemaSaude{" +
                "idProblemaSaude=" + idProblemaSaude +
                ", tipoProblema='" + tipoProblema + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProblemaSaude)) return false;
        ProblemaSaude that = (ProblemaSaude) o;
        return idProblemaSaude != null && idProblemaSaude.equals(that.idProblemaSaude);
    }

    @Override
    public int hashCode() {
        return idProblemaSaude != null ? idProblemaSaude.hashCode() : 0;
    }
}
