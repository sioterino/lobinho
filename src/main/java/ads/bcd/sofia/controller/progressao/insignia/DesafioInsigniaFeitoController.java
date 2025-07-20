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

        jovemController.printAll();
        System.out.println("Selecione um Jovem.");
        int idJovem = input.getId(jovemController.size());
        Jovem jovem = jovemController.getById(idJovem);
        dif.setJovem(jovem);
        System.out.println("Você selecionou: " + jovem.getNome() + ".");

        desafioInsigniaController.printAll();
        System.out.println("Selecione um Desafio de Insígnia.");
        int idRequisito = input.getId(desafioInsigniaController.size());
        DesafioInsignia desafio = desafioInsigniaController.getById(idRequisito);
        dif.setDesafioInsignia(desafio);
        System.out.println("Você selecionou: " + desafio.getNome() + ".");

        System.out.print("Data de conslusão (yyyy-MM-dd): ");
        dif.setData(input.getDate());

        service.save(dif);
        printAll();
    }

}
