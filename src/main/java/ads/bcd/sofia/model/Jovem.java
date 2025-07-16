package ads.bcd.sofia.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Jovem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idJovem;

    private String nome;
    private LocalDateTime dataNascimento;
    private String telefone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "idTipoSanguineo")
    private TipoSanguineo tipoSanguineo;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vinculo> vinculos;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Saude> problemasDeSaude;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<NoiteAcampada> noitesAcampadas;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioInsigniaFeita> desafiosInsigniaFeitos;

        @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioEspecialidadeFeita> desafiosEspecialidadeFeitos;

    @OneToMany(mappedBy = "jovem", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DesafioDistintivoFeita> desafiosDistintivoFeitos;

    public Integer getIdJovem() {
        return idJovem;
    }

    public void setIdJovem(Integer idJovem) {
        this.idJovem = idJovem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public TipoSanguineo getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(TipoSanguineo tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public List<Vinculo> getVinculos() {
        return vinculos;
    }

    public void setVinculos(List<Vinculo> vinculos) {
        this.vinculos = vinculos;
    }

    public List<Saude> getProblemasDeSaude() {
        return problemasDeSaude;
    }

    public void setProblemasDeSaude(List<Saude> problemasDeSaude) {
        this.problemasDeSaude = problemasDeSaude;
    }

    public List<NoiteAcampada> getNoitesAcampadas() {
        return noitesAcampadas;
    }

    public void setNoitesAcampadas(List<NoiteAcampada> noitesAcampadas) {
        this.noitesAcampadas = noitesAcampadas;
    }

    public List<DesafioInsigniaFeita> getDesafiosInsigniaFeitos() {
        return desafiosInsigniaFeitos;
    }

    public void setDesafiosInsigniaFeitos(List<DesafioInsigniaFeita> desafiosInsigniaFeitos) {
        this.desafiosInsigniaFeitos = desafiosInsigniaFeitos;
    }

    public List<DesafioEspecialidadeFeita> getDesafiosEspecialidadeFeitos() {
        return desafiosEspecialidadeFeitos;
    }

    public void setDesafiosEspecialidadeFeitos(List<DesafioEspecialidadeFeita> desafiosEspecialidadeFeitos) {
        this.desafiosEspecialidadeFeitos = desafiosEspecialidadeFeitos;
    }

    public List<DesafioDistintivoFeita> getDesafiosDistintivoFeitos() {
        return desafiosDistintivoFeitos;
    }

    public void setDesafiosDistintivoFeitos(List<DesafioDistintivoFeita> desafiosDistintivoFeitos) {
        this.desafiosDistintivoFeitos = desafiosDistintivoFeitos;
    }

}
