package ads.bcd.sofia.controller.saude;

import ads.bcd.sofia.model.saude.ProblemaSaude;
import ads.bcd.sofia.service.saude.ProblemaSaudeService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.*;
import java.util.stream.IntStream;

@Controller
@AllArgsConstructor
public class ProblemaSaudeController {

    private ProblemaSaudeService service;
    private Input input;

    public void printAll() {
        List<ProblemaSaude> problemas = service.findAll();
        if (problemas.isEmpty()) {
            System.out.println("Não há problemas de saúde cadastrados no sistema.");
            return;
        }

        Table.TableBuilder table = Table.createTable()
                .setTitle("PROBLEMAS DE SAÚDE")
                .addColumn("ID", 5)
                .addColumn("Tipo", 25)
                .addColumn("Descrição", 60);

        problemas.forEach(ps -> table.addRow(String.valueOf(ps.getIdProblemaSaude()), ps.getTipoProblema(), ps.getDescricao()));
        table.print();
    }

    public void printTipos(List<String> tipos) {
        if (tipos.isEmpty()) {
            System.out.println("Não há tipos de problemas de saúde cadastrados.");
            return;
        }

        Table.TableBuilder table = Table.createTable()
                .setTitle("TIPOS DE PROBLEMAS DE SAÚDE")
                .addColumn("ID", 5)
                .addColumn("Tipo", 25);

        IntStream.range(0, tipos.size()).forEach(i -> table.addRow(String.valueOf(i + 1), tipos.get(i)));

        table.print();
    }

    public void printProblemas(List<ProblemaSaude> problemas) {
        if (problemas.isEmpty()) {
            System.out.println("Não há problemas de saúde deste tipo.");
            return;
        }

        Table.TableBuilder table = Table.createTable()
                .setTitle("PROBLEMAS DE SAÚDE")
                .addColumn("ID", 5)
                .addColumn("Descrição", 60);

        problemas.forEach(ps -> table.addRow(String.valueOf(ps.getIdProblemaSaude()), ps.getDescricao()));
        table.print();
    }

    public String selectTipoProblema() {
        List<String> tipos = service.getAllTiposProblema();
        printTipos(tipos);
        System.out.println("Selecione um Tipo de Problema de Saúde:");
        int index = input.getId(rangeToList(tipos.size()));
        String tipo = tipos.get(index - 1);
        System.out.println("Você selecionou: " + tipo + ".");
        return tipo;
    }

    public ProblemaSaude selectProblemaSaude(String tipo) {
        List<ProblemaSaude> problemas = service.getByTipoProblema(tipo);
        printProblemas(problemas);
        System.out.println("Selecione um Problema de Saúde:");
        Integer idProblema = input.getId(getIds(problemas));
        ProblemaSaude problema = getById(idProblema);
        System.out.println("Você selecionou: " + problema.getDescricao() + ".");
        return problema;
    }

    private List<Integer> getIds(List<ProblemaSaude> problemas) {
        return problemas.stream().map(ProblemaSaude::getIdProblemaSaude).toList();
    }

    private List<Integer> rangeToList(int size) {
        return IntStream.rangeClosed(1, size).boxed().toList();
    }

    public ProblemaSaude getById(Integer id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível acessar Problema de Saúde no id " + id));
    }
}
