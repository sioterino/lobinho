package ads.bcd.sofia.controller.progressao.distintivo;

import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivo;
import ads.bcd.sofia.service.progressao.distintivo.DesafioDistintivoService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class DesafioDistintivoController {

    private DesafioDistintivoService service;
    private Input input;

    public void print(List<DesafioDistintivo> desafios) {
        if (desafios.isEmpty()) {
            System.out.println("Não há desafios de distintivos cadastrados.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("DESAFIOS DE DISTINTIVOS");
        table.addColumn("ID", 5);
        table.addColumn("Descrição", 35);
        table.addColumn("Distintivo", 15);

        for (DesafioDistintivo dd : desafios)
            table.addRow(String.valueOf(dd.getIdDesafioDistintivo()), dd.getDescricao(), dd.getDistintivo().getNome());
        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public DesafioDistintivo getById(int id) {
        Optional<DesafioDistintivo> desafio = service.findById(id);
        if (desafio.isEmpty())
            throw new RuntimeException("<DesafioDistintivoController> Não foi possível acessar Desafio Distintivo no id " + id);
        return desafio.get();
    }

    public List<Integer> getAllIds() {
        return service.findAll().stream().map(DesafioDistintivo::getIdDesafioDistintivo).collect(Collectors.toList());
    }

    public DesafioDistintivo selectDesafioDistintivo() {
        printAll();
        System.out.println("Selecione um Desafio de Distintivo.");
        int idRequisito = input.getId(getAllIds());
        DesafioDistintivo desafio = getById(idRequisito);
        System.out.println("Você selecionou: " + desafio.getDescricao() + ".");
        return desafio;
    }

}
