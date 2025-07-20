package ads.bcd.sofia.views;

import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.distintivo.Distintivo;
import ads.bcd.sofia.model.progressao.especialidade.Especialidade;
import ads.bcd.sofia.model.progressao.insignia.Insignia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JovemProgresso {

    private Jovem jovem;

    private List<Especialidade> especialidades;

    private List<Distintivo> distintivos;

    private List<Insignia> insignias;

}
