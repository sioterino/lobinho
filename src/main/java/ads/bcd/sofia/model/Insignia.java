package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Insignia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInsignia;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "insignia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioInsignia> desafios;

    public Integer getIdInsignia() {
        return idInsignia;
    }

    public void setIdInsignia(Integer idInsignia) {
        this.idInsignia = idInsignia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<DesafioInsignia> getDesafios() {
        return desafios;
    }

    public void setDesafios(List<DesafioInsignia> desafios) {
        this.desafios = desafios;
    }

    @Override
    public String toString() {
        return "Insignia{" +
                "idInsignia=" + idInsignia +
                ", nome='" + nome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insignia)) return false;
        Insignia that = (Insignia) o;
        return idInsignia != null && idInsignia.equals(that.idInsignia);
    }

    @Override
    public int hashCode() {
        return idInsignia != null ? idInsignia.hashCode() : 0;
    }
}
