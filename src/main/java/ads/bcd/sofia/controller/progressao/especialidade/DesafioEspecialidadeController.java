package ads.bcd.sofia.controller.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.DesafioEspecialidade;
import ads.bcd.sofia.service.progressao.especialidade.DesafioEspecialidadeService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class DesafioEspecialidadeController {

    private DesafioEspecialidadeService service;
    private Input input;

    public void printAll() {
        List<DesafioEspecialidade> desafios = service.findAll();
        if (desafios.isEmpty()) {
            System.out.println("Não há requisitos de especialidade cadastrados.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("REQUISITOS DE ESPECIALIDADE");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 30);
        table.addColumn("Especialidade", 20);

        for (DesafioEspecialidade de : desafios)
            table.addRow(String.valueOf(de.getIdDesafioEspecialidade()), de.getNome(), de.getEspecialidade().getNome());
        table.print();
    }

    public DesafioEspecialidade getById(int id) {
        Optional<DesafioEspecialidade> desafio = service.findById(id);
        if (desafio.isEmpty())
            throw new RuntimeException("<DesafioEspecialidadeController> Não foi possível acessar Desafio Especialidade no id " + id);
        return desafio.get();
    }

    public List<Integer> getAllIds() {
        return service.findAll().stream().map(DesafioEspecialidade::getIdDesafioEspecialidade).collect(Collectors.toList());
    }

    public DesafioEspecialidade selectDesafioEspecialidade() {
        printAll();
        System.out.println("Selecione um Requisito de Especialidade.");
        int idRequisito = input.getId(getAllIds());
        DesafioEspecialidade desafio = getById(idRequisito);
        System.out.println("Você selecionou: " + desafio.getNome() + ".");
        return desafio;
    }

}
