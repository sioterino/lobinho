package ads.bcd.sofia.controller.progressao.insignia;

import ads.bcd.sofia.model.progressao.insignia.DesafioInsignia;
import ads.bcd.sofia.service.progressao.insignia.DesafioInsigniaService;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class DesafioInsigniaController {

    private DesafioInsigniaService service;

    public void print(List<DesafioInsignia> desafios) {
        if (desafios.isEmpty()) {
            System.out.println("Não há desafios de insígnia cadastrados.");
            return;
        }

        Table.TableBuilder table =Table.createTable();
        table.setTitle("DESAFIOS DE INSÍGNIA");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 30);
        table.addColumn("Insígnia", 10);

        for (DesafioInsignia di : desafios)
            table.addRow(String.valueOf(di.getIdDesafioInsignia()), di.getNome(), di.getInsignia().getNome());
        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public DesafioInsignia getById(int id) {
        Optional<DesafioInsignia> desafio = service.findById(id);
        if (desafio.isEmpty())
            throw new RuntimeException("<DesafioInsigniaController> Não foi possível acessar Desafio Insígnia no id " + id);
        return desafio.get();
    }

    public int size() { return service.findAll().size(); }

}
