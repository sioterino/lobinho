package ads.bcd.sofia.controller.progressao.distintivo;

import ads.bcd.sofia.model.progressao.distintivo.Distintivo;
import ads.bcd.sofia.service.progressao.distintivo.DistintivoService;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class DistintivoController {

    private DistintivoService service;

    public void print(List<Distintivo> distintivos) {
        if (distintivos.isEmpty()) {
            System.out.println("Não há distintivos cadastrados.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("DISTINTIVOS");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 15);

        for (Distintivo d : distintivos)
            table.addRow(String.valueOf(d.getIdDistintivo()), d.getNome());
        table.print();
    }

    public void printAll() { print(service.findAll()); }

}
