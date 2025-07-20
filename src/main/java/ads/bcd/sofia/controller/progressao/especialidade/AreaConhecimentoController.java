package ads.bcd.sofia.controller.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.AreaConhecimento;
import ads.bcd.sofia.service.progressao.especialidade.AreaConhecimentoService;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class AreaConhecimentoController {

    private AreaConhecimentoService service;

    public void printAll() {
        List<AreaConhecimento> areas = service.findAll();
        if(areas.isEmpty()) {
            System.out.println("Não há areas de conhecimento cadastradas.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("ÁREAS DO CONHECIMENTO");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 20);

        for (AreaConhecimento ac : areas)
            table.addRow(String.valueOf(ac.getIdAreaConhecimento()), ac.getNome());
        table.print();
    }


}
