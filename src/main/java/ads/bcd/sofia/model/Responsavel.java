package ads.bcd.sofia.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Responsavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idResponsavel;

    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String telefone;
    @Column(nullable = false)
    private String email;

    public Responsavel() {}

    @OneToMany(mappedBy = "responsavel", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vinculo> vinculos;

    public Integer getIdResponsavel() {
        return idResponsavel;
    }

    public void setIdResponsavel(Integer idResponsavel) {
        this.idResponsavel = idResponsavel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Vinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Vinculo> vinculos) {
        this.vinculos = vinculos;
    }

    @Override
    public String toString() {
        return "Responsavel{" +
                "idResponsavel=" + idResponsavel +
                ", nome='" + nome + '\'' +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Responsavel that = (Responsavel) o;

        return Objects.equals(idResponsavel, that.idResponsavel);
    }

    @Override
    public int hashCode() {
        return idResponsavel != null ? idResponsavel.hashCode() : 0;
    }

}
