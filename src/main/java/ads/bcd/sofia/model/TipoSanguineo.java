package ads.bcd.sofia.model;

import jakarta.persistence.*;

@Entity
public class TipoSanguineo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTipoSanguineo;

    @Column(nullable = false)
    private String tipo;

    public TipoSanguineo() {}

    public Integer getIdTipoSanguineo() {
        return idTipoSanguineo;
    }

    public void setIdTipoSanguineo(Integer idTipoSanguineo) {
        this.idTipoSanguineo = idTipoSanguineo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoSanguineo{" +
                "idTipoSanguineo=" + idTipoSanguineo +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoSanguineo)) return false;
        TipoSanguineo that = (TipoSanguineo) o;
        return idTipoSanguineo != null && idTipoSanguineo.equals(that.idTipoSanguineo);
    }

    @Override
    public int hashCode() {
        return idTipoSanguineo != null ? idTipoSanguineo.hashCode() : 0;
    }
}
