package ads.bcd.sofia.controller.progressao.insignia;

import ads.bcd.sofia.model.progressao.insignia.Insignia;
import ads.bcd.sofia.service.progressao.insignia.InsigniaService;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class InsigniaController {

    private InsigniaService service;

    public void print(List<Insignia> insignias) {
        if (insignias.isEmpty()) {
            System.out.println("Não há insígnias cadastradas.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("INSÍGNIAS");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 10);

        for (Insignia i : insignias)
            table.addRow(String.valueOf(i.getIdInsignia()), i.getNome());
        table.print();
    }

    public void printAll() { print(service.findAll()); }

}
