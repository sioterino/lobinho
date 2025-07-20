package ads.bcd.sofia.controller.atividade;

import ads.bcd.sofia.model.atividade.Acampamentos;
import ads.bcd.sofia.service.atividade.AcampamentosService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class AcampamentosController {

    private AcampamentosService service;
    private Input input;

    public void print(List<Acampamentos> acampamentos) {
        if (acampamentos.isEmpty()) {
            System.out.println("Não há acampamentos cadastrados.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        Table.TableBuilder table = Table.createTable();
        table.setTitle("ACAMPAMENTOS");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 20);
        table.addColumn("Data", 15);

        for (Acampamentos a : acampamentos)
            table.addRow(String.valueOf(a.getIdAcampamento()), a.getNome(), a.getData().format(formatter));
        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public Acampamentos getById(int id) {
        Optional<Acampamentos> acampamento = service.findById(id);
        if (acampamento.isEmpty())
            throw new RuntimeException("<AcampamentoController> Não foi possível acessar o Acampamento no id " + id);
        return acampamento.get();
    }

    public List<Integer> getAllIds() {
        return service.findAll().stream().map(Acampamentos::getIdAcampamento).collect(Collectors.toList());
    }

    public Acampamentos selectAcampamento() {
        printAll();
        System.out.println("Selecione um Acampamento.");
        int idRequisito = input.getId(getAllIds());
        Acampamentos acampamentos = getById(idRequisito);
        System.out.println("Você selecionou: " + acampamentos.getNome() + ".");
        return acampamentos;
    }

}
