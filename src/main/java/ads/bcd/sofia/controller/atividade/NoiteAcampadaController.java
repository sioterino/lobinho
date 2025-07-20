package ads.bcd.sofia.controller.atividade;

import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.model.atividade.Acampamentos;
import ads.bcd.sofia.model.atividade.NoiteAcampada;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivo;
import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivoFeita;
import ads.bcd.sofia.service.atividade.NoiteAcampadaService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class NoiteAcampadaController {

    private NoiteAcampadaService service;
    private Input input;

    private JovemController jovemController;
    private AcampamentosController acampamentosController;

    public void print(List<NoiteAcampada> noites) {
        if (noites.isEmpty()) {
            System.out.println("Não há noites acampadas cadastradas.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        Table.TableBuilder table = Table.createTable();
        table.setTitle("NOITES ACAMPADAS");
        table.addColumn("ID", 5);
        table.addColumn("Jovem Nome", 20);
        table.addColumn("Acampamento", 20);
        table.addColumn("Data", 15);

        for (NoiteAcampada na : noites)
            table.addRow(String.valueOf(na.getId()), na.getJovem().getNome(),
                na.getAcampamentos().getNome(), na.getAcampamentos().getData().format(formatter));
        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public void create() {
        System.out.println("Registro de Jovem que Participou de um Acampamento\n");

        NoiteAcampada na = new NoiteAcampada();

        jovemController.printAll();
        System.out.println("Selecione um Jovem.");
        int idJovem = input.getId(jovemController.size());
        Jovem jovem = jovemController.getById(idJovem);
        na.setJovem(jovem);
        System.out.println("Você selecionou: " + jovem.getNome() + ".");

        acampamentosController.printAll();
        System.out.println("Selecione um Acampamento.");
        int idRequisito = input.getId(acampamentosController.size());
        Acampamentos acampamentos = acampamentosController.getById(idRequisito);
        na.setAcampamentos(acampamentos);
        System.out.println("Você selecionou: " + acampamentos.getNome() + ".");

        service.save(na);
        printAll();}
}
