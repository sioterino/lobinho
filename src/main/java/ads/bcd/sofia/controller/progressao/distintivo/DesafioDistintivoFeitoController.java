package ads.bcd.sofia.controller.progressao.distintivo;

import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivo;
import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivoFeita;
import ads.bcd.sofia.service.progressao.distintivo.DesafioDistintivoFeitoService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class DesafioDistintivoFeitoController {

    private DesafioDistintivoFeitoService service;
    private Input input;

    private JovemController jovemController;
    private final DesafioDistintivoController desafioDistintivoController;

    public void print(List<DesafioDistintivoFeita> desafios) {
        if (desafios.isEmpty()) {
            System.out.println("Não há desafios de distintivos cadastrados.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        Table.TableBuilder table = Table.createTable();
        table.setTitle("DESAFIOS DE DISTINTIVOS CONCLUÍDOS");
        table.addColumn("ID", 5);
        table.addColumn("Jovem Nome", 20);
        table.addColumn("Desafio", 35);
        table.addColumn("Distintivo", 15);
        table.addColumn("Início", 15);
        table.addColumn("Conclusão", 15);

        for (DesafioDistintivoFeita ddf : desafios)
            table.addRow(String.valueOf(ddf.getId()), ddf.getJovem().getNome(), ddf.getDesafioDistintivo().getDescricao(),
                    ddf.getDesafioDistintivo().getDistintivo().getNome(), ddf.getDataInicio().format(formatter), ddf.getDataFim().format(formatter));
        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public void create() {
        System.out.println("Registro de Jovem que Completou Desafio para Distintivo\n");
        DesafioDistintivoFeita ddf = new DesafioDistintivoFeita();

        Jovem jovem = jovemController.selectJovem();
        ddf.setJovem(jovem);
        DesafioDistintivo desafio = desafioDistintivoController.selectDesafioDistintivo();
        ddf.setDesafioDistintivo(desafio);

        System.out.print("Data de Inicio (yyyy-MM-dd): ");
        ddf.setDataInicio(input.getDate());
        System.out.print("Data de Conclusão (yyyy-MM-dd): ");
        ddf.setDataFim(input.getDate());

        service.save(ddf);
        printAll();
    }

    public void getDistintivoByJovem() {
        System.out.println("Consultar Distintivo de um Determinado Jovem\n");
        Jovem jovem = jovemController.selectJovem();
        List<DesafioDistintivoFeita> desafios = service.getDesafioInsigniaByJovemId(jovem.getIdJovem());

        if (desafios.isEmpty()) {
            System.out.println("Não há distintivos cadastrados para esse jovem.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        Table.TableBuilder table = Table.createTable();
        table.setTitle("DISTINTIVOS DE " + jovem.getNome().toUpperCase());
        table.addColumn("Desafio", 35);
        table.addColumn("Distintivo", 15);
        table.addColumn("Início", 15);
        table.addColumn("Conclusão", 15);
        for (DesafioDistintivoFeita ddf : desafios)
            table.addRow(ddf.getDesafioDistintivo().getDescricao(), ddf.getDesafioDistintivo().getDistintivo().getNome(),
                    ddf.getDataInicio().format(formatter), ddf.getDataFim().format(formatter));
        table.print();
    }

}
