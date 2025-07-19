package ads.bcd.sofia.controller.pessoa;

import ads.bcd.sofia.model.pessoa.Responsavel;
import ads.bcd.sofia.service.pessoa.ResponsavelService;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class ResponsavelController {

    private ResponsavelService service;

    public void printAll() {
        List<Responsavel> responsaveis = service.findAll();

        if (responsaveis.isEmpty()) {
            System.out.println("Nenhum responsável cadastrado.\n");
            return;
        }

        Table.TableBuilder table = Table.createTable();

        table.setTitle("RESPONSÁVEIS");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 20);
        table.addColumn("Email", 25);
        table.addColumn("Telefone", 20);

        for (Responsavel r : responsaveis)
            table.addRow(String.valueOf(r.getIdResponsavel()), r.getNome(), r.getEmail(),  r.getTelefone());

        table.print();
    }

    public Responsavel getById(int id) {
        Optional<Responsavel> object = service.findById(id);
        if (object.isEmpty()) throw new RuntimeException("<ResponsavelController> Não foi acessar responsável no id " + id);
        return object.get();
    }

    public int size() {
        return service.findAll().size();
    }

}
