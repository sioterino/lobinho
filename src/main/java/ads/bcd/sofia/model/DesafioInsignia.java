package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DesafioInsignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDesafio;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "idInsignia", nullable = false)
    private Insignia insignia;

    @OneToMany(mappedBy = "desafio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioInsigniaFeita> completacoes;

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

    public Insignia getInsignia() {
        return insignia;
    }

    public void setInsignia(Insignia insignia) {
        this.insignia = insignia;
    }

    public List<DesafioInsigniaFeita> getCompletacoes() {
        return completacoes;
    }

    public void setCompletacoes(List<DesafioInsigniaFeita> completacoes) {
        this.completacoes = completacoes;
    }

    @Override
    public String toString() {
        return "DesafioInsignia{" +
                "idDesafio=" + idDesafio +
                ", nome='" + nome + '\'' +
                ", insignia=" + (insignia != null ? insignia.getIdInsignia() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DesafioInsignia)) return false;
        DesafioInsignia that = (DesafioInsignia) o;
        return idDesafio != null && idDesafio.equals(that.idDesafio);
    }

    @Override
    public int hashCode() {
        return idDesafio != null ? idDesafio.hashCode() : 0;
    }
}
