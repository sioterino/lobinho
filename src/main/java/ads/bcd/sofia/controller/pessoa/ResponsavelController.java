package ads.bcd.sofia.controller.pessoa;

import ads.bcd.sofia.model.pessoa.Responsavel;
import ads.bcd.sofia.service.pessoa.ResponsavelService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class ResponsavelController {

    private ResponsavelService service;
    private Input input;

    public void print(List<Responsavel> responsaveis) {
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

    public void printAll() { print(service.findAll()); }

    public void simplePrint(List<Responsavel> responsaveis) {
        if (responsaveis.isEmpty()) {
            System.out.println("Nenhum responsável cadastrado.\n");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("RESPONSÁVEIS");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 20);
        for (Responsavel r : responsaveis)
            table.addRow(String.valueOf(r.getIdResponsavel()), r.getNome());
        table.print();
    }

    public void simplePrintAll() { simplePrint(service.findAll()); }

    public Responsavel getById(int id) {
        Optional<Responsavel> object = service.findById(id);
        if (object.isEmpty()) throw new RuntimeException("<ResponsavelController> Não foi acessar responsável no id " + id);
        return object.get();
    }

    public List<Integer> getAllIds() {
        return service.findAll().stream().map(Responsavel::getIdResponsavel).collect(Collectors.toList());
    }

    public Responsavel selectResponsavel() {
        simplePrintAll();
        System.out.println("\nEscolha um responsável.");
        int idResponsavel = input.getId(getAllIds());
        Responsavel responsavel = getById(idResponsavel);
        System.out.println("Você selecionou" + responsavel.getNome() + ".");
        return responsavel;
    }

}
