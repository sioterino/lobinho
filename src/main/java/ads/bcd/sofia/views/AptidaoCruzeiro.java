package ads.bcd.sofia.views;

import ads.bcd.sofia.model.pessoa.Jovem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AptidaoCruzeiro {

    private Jovem jovem;

    private boolean possuiCruzeiroDoSul;

    private boolean prontoParaCruzeiroDoSul;

}
