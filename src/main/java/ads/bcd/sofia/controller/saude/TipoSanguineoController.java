package ads.bcd.sofia.controller.saude;

import ads.bcd.sofia.model.saude.TipoSanguineo;
import ads.bcd.sofia.service.saude.TipoSanguineoService;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class TipoSanguineoController {

    private final TipoSanguineoService service;

    public void printAll() {

        List<TipoSanguineo> tipos = service.findAll();

        if (tipos.isEmpty()) {
            System.out.println("Nenhhum tipo sanguineo cadastrado.\n");
            return;
        }

        Table.TableBuilder table = Table.createTable();

        table.setTitle("TIPOS SANGUÍNEOS");
        table.addColumn("ID", 6);
        table.addColumn("Tipo", 7);

        for (TipoSanguineo ts : tipos)
            table.addRow(String.valueOf(String.valueOf(ts.getIdTipoSanguineo())), ts.getTipo());

        table.print();
    }

    public TipoSanguineo getById(int id) {
        Optional<TipoSanguineo> tipo = service.findById(id);
        if (tipo.isEmpty()) throw new RuntimeException("<TipoSanguineoController> Não foi possível acessar Tipo Sanguíneo no id " + id);
        return tipo.get();
    }

    public int size() {
        return service.findAll().size();
    }

}
