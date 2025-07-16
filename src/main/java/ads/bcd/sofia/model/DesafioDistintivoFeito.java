package ads.bcd.sofia.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class DesafioDistintivoFeito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "idDesafioDistintivo", nullable = false)
    private DesafioDistintivo desafioDistintivo;

    @ManyToOne
    @JoinColumn(name = "idJovem", nullable = false)
    private Jovem jovem;

    @Column(nullable = false)
    private LocalDateTime dataInicio;

    @Column(nullable = false)
    private LocalDateTime dataFim;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DesafioDistintivo getDesafioDistintivo() {
        return desafioDistintivo;
    }

    public void setDesafioDistintivo(DesafioDistintivo desafioDistintivo) {
        this.desafioDistintivo = desafioDistintivo;
    }

    public Jovem getJovem() {
        return jovem;
    }

    public void setJovem(Jovem jovem) {
        this.jovem = jovem;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDateTime dataFim) {
        this.dataFim = dataFim;
    }

    @Override
    public String toString() {
        return "DesafioDistintivoFeita{" +
                "id=" + id +
                ", desafioDistintivo=" + (desafioDistintivo != null ? desafioDistintivo.getIdDesafioDistintivo() : "null") +
                ", jovem=" + (jovem != null ? jovem.getIdJovem() : "null") +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesafioDistintivoFeito)) return false;
        DesafioDistintivoFeito that = (DesafioDistintivoFeito) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
