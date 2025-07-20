package ads.bcd.sofia.controller.progressao.insignia;

import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.insignia.DesafioInsignia;
import ads.bcd.sofia.model.progressao.insignia.DesafioInsigniaFeita;
import ads.bcd.sofia.service.progressao.insignia.DesafioInsigniaFeitoService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class DesafioInsigniaFeitoController {

    private DesafioInsigniaFeitoService service;
    private Input input;

    private JovemController jovemController;
    private DesafioInsigniaController desafioInsigniaController;

    public void print(List<DesafioInsigniaFeita> feitos) {
        if (feitos.isEmpty()) {
            System.out.println("Não há Jovens que concluíram desafios de insígnia.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        Table.TableBuilder table = Table.createTable();
        table.setTitle("DESAFIOS DE INSÍGNIA CONCLUIDOS");
        table.addColumn("ID", 5);
        table.addColumn("Jovem Nome", 20);
        table.addColumn("Desafio", 30);
        table.addColumn("Insígnia", 10);
        table.addColumn("Conclusão", 15);

        for (DesafioInsigniaFeita dif : feitos)
            table.addRow(String.valueOf(dif.getId()), dif.getJovem().getNome(), dif.getDesafioInsignia().getNome(),
                        dif.getDesafioInsignia().getInsignia().getNome(), dif.getData().format(formatter));
        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public void create() {
        System.out.println("Registro de Jovem que Completou Desafio para Insígnia\n");

        DesafioInsigniaFeita dif = new DesafioInsigniaFeita();

        Jovem jovem = jovemController.selectJovem();
        dif.setJovem(jovem);
        DesafioInsignia desafio = desafioInsigniaController.selectDesafioInsignia();
        dif.setDesafioInsignia(desafio);

        System.out.print("Data de conslusão (yyyy-MM-dd): ");
        dif.setData(input.getDate());

        service.save(dif);
        printAll();
    }

    public void getInsigniaByJovem() {
        System.out.println("Consultar Especialidades de um Determinado Jovem\n");
        Jovem jovem = jovemController.selectJovem();
        List<DesafioInsigniaFeita> desafios = service.getDesafioInsigniaByJovemId(jovem.getIdJovem());

        if (desafios.isEmpty()) {
            System.out.println("Não há insígnias cadastradas para esse jovem.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        Table.TableBuilder table = Table.createTable();
        table.setTitle("ESPECIALIDADES DE " + jovem.getNome().split("0", 1)[0].toUpperCase());
        table.addColumn("Desafio", 30);
        table.addColumn("Insígnia", 10);
        table.addColumn("Conclusão", 15);
        for (DesafioInsigniaFeita dif : desafios)
            table.addRow(dif.getDesafioInsignia().getNome(),
                    dif.getDesafioInsignia().getInsignia().getNome(),
                    dif.getData().format(formatter));
        table.print();
    }
}
