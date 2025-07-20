package ads.bcd.sofia.controller.views;

import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.service.views.AptidaoCruzeiroService;
import ads.bcd.sofia.utils.Table;
import ads.bcd.sofia.views.AptidaoCruzeiro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class AptidaoCruzeiroController {

    private AptidaoCruzeiroService service;
    private JovemController jovemController;

    public Jovem getJovemApto(Integer id) {
        AptidaoCruzeiro apto = service.getProgresso(id);
        if (!apto.isPossuiCruzeiroDoSul() && apto.isProntoParaCruzeiroDoSul())
            return apto.getJovem();
        else return null;
    }

    public List<Jovem> getAllJovemApto() {
        List<Integer> jovens = jovemController.getAllIds();
        List<Jovem> jovensAptos = new ArrayList<>();
        for (Integer id : jovens) {
            Jovem jovem = getJovemApto(id);
            if (jovem != null) jovensAptos.add(jovem);
        }
        return jovensAptos;
    }

    public void print(List<Jovem> jovens) {
        if (jovens.isEmpty()) {
            System.out.println("Não há jovens aptos out todos os jovens aptos já possuem Cruzeiro do Sul.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("JOVENS APTOS AO CRUZEIRO DO SUL");
        table.addColumn("Jovens", 35);

        for (Jovem j : jovens) table.addRow(j.getNome());
        table.print();
    }

    public void printAll() { print(getAllJovemApto()); }

}
